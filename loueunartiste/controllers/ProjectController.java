package fr.formation.loueunartiste.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.loueunartiste.domain.dtos.ProjectArtistView;
import fr.formation.loueunartiste.domain.dtos.ProjectCreate;
import fr.formation.loueunartiste.services.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
	this.service = service;
    }

    @GetMapping("/search")
    public List<ProjectArtistView> search(
	    @Valid @RequestBody ProjectCreate inputs) {
	service.search(inputs);
	return null;
    }

}
