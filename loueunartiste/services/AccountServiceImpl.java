package fr.formation.loueunartiste.services;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.formation.loueunartiste.domain.dtos.AccountCreate;
import fr.formation.loueunartiste.domain.dtos.AccountLogin;
import fr.formation.loueunartiste.domain.dtos.ArtistCreate;
import fr.formation.loueunartiste.domain.entities.Account;
import fr.formation.loueunartiste.domain.entities.Artist;
import fr.formation.loueunartiste.domain.entities.Role;
import fr.formation.loueunartiste.domain.entities.UserProfile;
import fr.formation.loueunartiste.repositories.AccountRepository;
import fr.formation.loueunartiste.repositories.ArtistRepository;
import fr.formation.loueunartiste.repositories.RoleRepository;
import fr.formation.loueunartiste.repositories.UserProfileRepository;
import fr.formation.loueunartiste.security.BadCredentialsException;
import fr.formation.loueunartiste.security.IdToken;
import fr.formation.loueunartiste.security.TokenProvider;

@Service
public class AccountServiceImpl implements AccountService {

    private final PasswordEncoder encoder;
    private final TokenProvider provider;
    private final AccountRepository accounts;
    private final RoleRepository roles;
    private final UserProfileRepository userProfiles;
    private final ArtistRepository artists;

    public AccountServiceImpl(PasswordEncoder encoder, TokenProvider provider,
	    AccountRepository accounts, RoleRepository roles,
	    UserProfileRepository userProfils, ArtistRepository artists) {
	this.encoder = encoder;
	this.provider = provider;
	this.accounts = accounts;
	this.roles = roles;
	this.userProfiles = userProfils;
	this.artists = artists;
    }

    @Override
    public void create(AccountCreate inputs) {
	String username = inputs.getUsername();
	String raw = inputs.getPassword();
	Role role = roles.findByCode("ROLE_CLIENT");
	Account account = this.createAccount(username, raw, role);
	this.createUserProfile(username, account);
    }

    @Override
    public void create(@Valid ArtistCreate inputs) {
	Artist artistEntity = new Artist();
	String username = inputs.getUsername();
	String raw = inputs.getPassword();
	Role role = roles.findByCode("ROLE_ARTIST");
	Account account = this.createAccount(username, raw, role);
	this.createUserProfile(username, account);
	artistEntity.setAccount(account);
	artistEntity.setArtistName(inputs.getArtistName());
	artistEntity.setPortfolioUrl(inputs.getPortfolioUrl());
	artistEntity.setAvailable(false);
	artistEntity.setArtFormat(null);
	artistEntity.setArtMedium(null);
	artists.save(artistEntity);
    }

    private Account createAccount(String username, String raw, Role role) {
	Account accountEntity = new Account();
	accountEntity.setUsername(username);
	String encoded = encoder.encode(raw);
	accountEntity.setPassword(encoded);
	accountEntity.setRegistrationDate(LocalDateTime.now());
	accountEntity.setEnabled(true);
	accountEntity.setRole(role);
	return accounts.save(accountEntity);
    }

    private void createUserProfile(String username, Account account) {
	UserProfile userProfilEntity = new UserProfile();
	userProfilEntity.setAccount(account);
	userProfilEntity.setEmail(username);
	userProfiles.save(userProfilEntity);
    }

    @Override
    public IdToken login(AccountLogin inputs) {
	String username = inputs.getUsername();
	Account accountEntity = accounts.findByUsernameAndEnabledTrue(username)
		.orElseThrow(() -> new BadCredentialsException(
			"/!\\ Username not found : " + username));
	String encoded = accountEntity.getPassword();
	String raw = inputs.getPassword();
	if (!encoder.matches(raw, encoded)) {
	    throw new BadCredentialsException(
		    "/!\\ Bad password for usernmae : " + username);
	}
	List<String> authorities = List.of(accountEntity.getRole().getCode());
	return provider.idToken(String.valueOf(accountEntity.getId()),
		authorities);
    }

}
