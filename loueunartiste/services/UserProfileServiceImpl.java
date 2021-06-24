package fr.formation.loueunartiste.services;

import org.springframework.stereotype.Service;

import fr.formation.loueunartiste.repositories.UserProfileRepository;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfiles;

    public UserProfileServiceImpl(
	    UserProfileRepository userProfiles) {
	this.userProfiles = userProfiles;
    }

}
