package fr.formation.loueunartiste.services;

import java.util.List;

import javax.validation.Valid;

import fr.formation.loueunartiste.domain.dtos.ProjectArtistView;
import fr.formation.loueunartiste.domain.dtos.ProjectCreate;

public interface ProjectService {

    List<ProjectArtistView> search(@Valid ProjectCreate inputs);

}
