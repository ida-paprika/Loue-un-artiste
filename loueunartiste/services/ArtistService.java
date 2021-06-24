package fr.formation.loueunartiste.services;

import fr.formation.loueunartiste.domain.dtos.ArtistAvailableUpdate;
import fr.formation.loueunartiste.domain.dtos.ArtistView;
import fr.formation.loueunartiste.domain.dtos.MediumAndFormatCreate;

public interface ArtistService {

    void addMediumAndFormat(Long accountId, MediumAndFormatCreate inputs);

    void updateAvailable(Long accountId, ArtistAvailableUpdate input);

    ArtistView getOne(Long accountId);

}
