package fr.formation.loueunartiste.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.formation.loueunartiste.domain.dtos.UserCreate;
import fr.formation.loueunartiste.domain.dtos.UserLogin;
import fr.formation.loueunartiste.domain.entities.SocialInformation;
import fr.formation.loueunartiste.domain.entities.User;
import fr.formation.loueunartiste.repositories.RoleRepository;
import fr.formation.loueunartiste.repositories.SocialInformationRepository;
import fr.formation.loueunartiste.repositories.UserRepository;
import fr.formation.loueunartiste.security.BadCredentialsException;
import fr.formation.loueunartiste.security.IdToken;
import fr.formation.loueunartiste.security.TokenProvider;

@Service
public class UserServiceImpl implements UserService {

    private final PasswordEncoder encoder;

    private final TokenProvider provider;

    private final UserRepository users;

    private final RoleRepository roles;

    private final SocialInformationRepository socialInfos;

    public UserServiceImpl(PasswordEncoder encoder, TokenProvider provider,
	    UserRepository users, RoleRepository roles,
	    SocialInformationRepository socialInfos) {
	this.encoder = encoder;
	this.provider = provider;
	this.users = users;
	this.roles = roles;
	this.socialInfos = socialInfos;
    }

    @Override
    public void create(UserCreate inputs) {
	User userEntity = new User();
	userEntity.setUsername(inputs.getUsername());
	String raw = inputs.getPassword();
	String encoded = encoder.encode(raw);
	userEntity.setPassword(encoded);
	userEntity.setRegistrationDate(LocalDateTime.now());
	userEntity.setEnabled(true);
	userEntity.setRole(roles.findByCode("ROLE_CLIENT"));
	User user = users.save(userEntity);
	this.createSocialInfo(inputs, user);
    }

    public void createSocialInfo(UserCreate inputs, User user) {
	SocialInformation socialInfoEntity = new SocialInformation();
	socialInfoEntity.setUser(user);
	socialInfoEntity.setEmail(inputs.getUsername());
	socialInfos.save(socialInfoEntity);
    }

    @Override
    public IdToken login(UserLogin inputs) {
	String username = inputs.getUsername();
	User entity = users.findByUsernameAndEnabledTrue(username)
		.orElseThrow(() -> new BadCredentialsException(
			"/!\\ Username not found : " + username));
	String encoded = entity.getPassword();
	String raw = inputs.getPassword();
	if (!encoder.matches(raw, encoded)) {
	    throw new BadCredentialsException(
		    "/!\\ Bad password for usernmae : " + username);
	}
	List<String> authorities = List.of(entity.getRole().getCode());
	return provider.idToken(username, authorities);
    }

}
