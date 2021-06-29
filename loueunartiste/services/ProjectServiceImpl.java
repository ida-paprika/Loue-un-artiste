package fr.formation.loueunartiste.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import fr.formation.loueunartiste.domain.dtos.ProjectArtistView;
import fr.formation.loueunartiste.domain.dtos.ProjectCreate;
import fr.formation.loueunartiste.repositories.AccountRepository;
import fr.formation.loueunartiste.repositories.ArtFormatRepository;
import fr.formation.loueunartiste.repositories.ArtMediumRepository;
import fr.formation.loueunartiste.repositories.ArtistRepository;
import fr.formation.loueunartiste.repositories.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projects;
    private final ArtistRepository artists;
    private final AccountRepository accounts;
    private final ArtMediumRepository artMediums;
    private final ArtFormatRepository artFormats;

    public ProjectServiceImpl(ProjectRepository projects,
	    ArtistRepository artists, AccountRepository accounts,
	    ArtMediumRepository artMediums, ArtFormatRepository artFormats) {
	this.projects = projects;
	this.artists = artists;
	this.accounts = accounts;
	this.artMediums = artMediums;
	this.artFormats = artFormats;
    }

    @Override
    public List<ProjectArtistView> search(@Valid ProjectCreate inputs) {

	return null;
    }

}
