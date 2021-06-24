package fr.formation.loueunartiste.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.loueunartiste.domain.dtos.ArtMediumView;
import fr.formation.loueunartiste.services.ArtMediumService;

@RestController
@RequestMapping("/mediums")
public class ArtMediumController {

    private final ArtMediumService service;

    public ArtMediumController(ArtMediumService service) {
	this.service = service;
    }

    @GetMapping("/all-mediums")
    public List<ArtMediumView> getAll() {
	return service.getAll();

    }
}
