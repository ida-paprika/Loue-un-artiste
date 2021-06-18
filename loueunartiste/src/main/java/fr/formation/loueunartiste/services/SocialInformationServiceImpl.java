package fr.formation.loueunartiste.services;

import org.springframework.stereotype.Service;

import fr.formation.loueunartiste.repositories.SocialInformationRepository;

@Service
public class SocialInformationServiceImpl implements SocialInformationService {

    private final SocialInformationRepository socialInfos;

    public SocialInformationServiceImpl(
	    SocialInformationRepository socialInfos) {
	this.socialInfos = socialInfos;
    }

}
