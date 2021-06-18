package fr.formation.loueunartiste.services;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.formation.loueunartiste.domain.dtos.ArtistCreate;
import fr.formation.loueunartiste.domain.entities.Artist;
import fr.formation.loueunartiste.domain.entities.SocialInformation;
import fr.formation.loueunartiste.domain.entities.User;
import fr.formation.loueunartiste.repositories.ArtistRepository;
import fr.formation.loueunartiste.repositories.RoleRepository;
import fr.formation.loueunartiste.repositories.SocialInformationRepository;
import fr.formation.loueunartiste.repositories.UserRepository;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final PasswordEncoder encoder;
    private final ArtistRepository artists;
    private final RoleRepository roles;
    private final UserRepository users;
    private final SocialInformationRepository socialInfos;

    public ArtistServiceImpl(PasswordEncoder encoder, ArtistRepository artists,
	    RoleRepository roles, UserRepository users,
	    SocialInformationRepository socialInfos) {
	this.encoder = encoder;
	this.artists = artists;
	this.roles = roles;
	this.users = users;
	this.socialInfos = socialInfos;
    }

    @Override
    public void create(ArtistCreate inputs) {
	Artist artistEntity = new Artist();
	User user = this.createUser(inputs);
	this.createSocialInfo(inputs, user);
	artistEntity.setUser(user);
	artistEntity.setArtistName(inputs.getArtistName());
	artistEntity.setPortfolioUrl(inputs.getPortfolioUrl());
	artistEntity.setArtFormat(null);
	artistEntity.setArtMedium(null);
	artists.save(artistEntity);
    }

    public User createUser(ArtistCreate inputs) {
	User userEntity = new User();
	userEntity.setUsername(inputs.getUsername());
	String raw = inputs.getPassword();
	String encoded = encoder.encode(raw);
	userEntity.setPassword(encoded);
	userEntity.setRegistrationDate(LocalDateTime.now());
	userEntity.setEnabled(true);
	userEntity.setRole(roles.findByCode("ROLE_ARTIST"));
	return users.save(userEntity);
    }

    public void createSocialInfo(ArtistCreate inputs, User user) {
	SocialInformation socialInfoEntity = new SocialInformation();
	socialInfoEntity.setUser(user);
	socialInfoEntity.setEmail(inputs.getUsername());
	socialInfos.save(socialInfoEntity);
    }

}
