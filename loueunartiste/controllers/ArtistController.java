package fr.formation.loueunartiste.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.loueunartiste.domain.dtos.ArtistAvailableUpdate;
import fr.formation.loueunartiste.domain.dtos.ArtistView;
import fr.formation.loueunartiste.domain.dtos.MediumAndFormatCreate;
import fr.formation.loueunartiste.security.SecurityHelper;
import fr.formation.loueunartiste.services.ArtistService;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    private final ArtistService service;

    public ArtistController(ArtistService service) {
	this.service = service;
    }

    @GetMapping("/{id}/profile")
    public ArtistView getOne() {
	Long accountId = SecurityHelper.accountId();
	return service.getOne(accountId);
    }

    @PostMapping("/{id}/mediums-formats")
    public void createMediumAndFormat(
	    @RequestBody MediumAndFormatCreate inputs) {
	Long accountId = SecurityHelper.accountId();
	service.createMediumAndFormat(accountId, inputs);
    }

    @PatchMapping("/{id}/mediums-formats")
    public void updateMediumAndFormat(
	    @RequestBody MediumAndFormatCreate inputs) {
	Long accountId = SecurityHelper.accountId();
	service.updateMediumAndFormat(accountId, inputs);
    }

    @PatchMapping("/{id}/available")
    public void updateAvailable(
	    @Valid @RequestBody ArtistAvailableUpdate input) {
	Long accountId = SecurityHelper.accountId();
	service.updateAvailable(accountId, input);
    }

}
