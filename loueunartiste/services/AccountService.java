package fr.formation.loueunartiste.services;

import javax.validation.Valid;

import fr.formation.loueunartiste.domain.dtos.AccountCreate;
import fr.formation.loueunartiste.domain.dtos.AccountLogin;
import fr.formation.loueunartiste.domain.dtos.ArtistCreate;
import fr.formation.loueunartiste.security.IdToken;

public interface AccountService {

    void create(AccountCreate inputs);

    IdToken login(@Valid AccountLogin inputs);

    void create(@Valid ArtistCreate inputs);

}
