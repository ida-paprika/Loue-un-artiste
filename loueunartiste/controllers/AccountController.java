package fr.formation.loueunartiste.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.loueunartiste.domain.dtos.AccountCreate;
import fr.formation.loueunartiste.domain.dtos.AccountLogin;
import fr.formation.loueunartiste.domain.dtos.ArtistCreate;
import fr.formation.loueunartiste.security.IdToken;
import fr.formation.loueunartiste.services.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
	this.service = service;
    }

    @PostMapping("/role-client")
    public void create(@Valid @RequestBody AccountCreate inputs) {
	service.create(inputs);
    }

    @PostMapping("/role-artist")
    public void create(@Valid @RequestBody ArtistCreate inputs) {
	service.create(inputs);
    }

    @PostMapping("/login")
    public IdToken login(@Valid @RequestBody AccountLogin inputs) {
	return service.login(inputs);
    }

}
