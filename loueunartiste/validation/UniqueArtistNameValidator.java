package fr.formation.loueunartiste.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.formation.loueunartiste.repositories.ArtistRepository;

public class UniqueArtistNameValidator
	implements ConstraintValidator<UniqueArtistName, String> {

    private final ArtistRepository artists;

    public UniqueArtistNameValidator(ArtistRepository artists) {
	super();
	this.artists = artists;
    }

    @Override
    public boolean isValid(String artistName,
	    ConstraintValidatorContext context) {
	if (artistName == null) {
	    return true;
	}
	return !artists.existsByArtistName(artistName);
    }

}
