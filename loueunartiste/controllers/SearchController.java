package fr.formation.loueunartiste.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.loueunartiste.domain.dtos.ContactArtistCreate;
import fr.formation.loueunartiste.domain.dtos.SearchArtistCreate;
import fr.formation.loueunartiste.services.AccountService;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final AccountService service;

    public SearchController(AccountService service) {
	this.service = service;
    }

    @PostMapping
    public List<ContactArtistCreate> search(
	    @Valid @RequestBody SearchArtistCreate inputs) {

	return null;
    }

}
