package fr.formation.loueunartiste.services;

import java.util.List;

import fr.formation.loueunartiste.domain.dtos.ArtMediumView;

public interface ArtMediumService {

    List<ArtMediumView> getAll();

}
