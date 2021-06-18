package fr.formation.loueunartiste.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.loueunartiste.domain.dtos.ArtistCreate;
import fr.formation.loueunartiste.services.ArtistService;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistService service;

    public ArtistController(ArtistService service) {
	this.service = service;
    }

    @PostMapping
    public void create(@Valid @RequestBody ArtistCreate inputs) {
	service.create(inputs);
    }

}
