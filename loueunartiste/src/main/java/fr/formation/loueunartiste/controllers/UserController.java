package fr.formation.loueunartiste.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.loueunartiste.domain.dtos.UserCreate;
import fr.formation.loueunartiste.domain.dtos.UserLogin;
import fr.formation.loueunartiste.security.IdToken;
import fr.formation.loueunartiste.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
	this.service = service;
    }

    @PostMapping
    public void create(@Valid @RequestBody UserCreate inputs) {
	service.create(inputs);
    }

    @PostMapping("/login")
    public IdToken login(@Valid @RequestBody UserLogin inputs) {
	return service.login(inputs);
    }

}
