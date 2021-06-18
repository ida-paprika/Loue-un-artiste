package fr.formation.loueunartiste.services;

import javax.validation.Valid;

import fr.formation.loueunartiste.domain.dtos.UserCreate;
import fr.formation.loueunartiste.domain.dtos.UserLogin;
import fr.formation.loueunartiste.security.IdToken;

public interface UserService {

    void create(UserCreate dto);

    IdToken login(@Valid UserLogin inputs);

}
