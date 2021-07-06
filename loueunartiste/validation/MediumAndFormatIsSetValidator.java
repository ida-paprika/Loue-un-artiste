package fr.formation.loueunartiste.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.formation.loueunartiste.domain.entities.Artist;
import fr.formation.loueunartiste.repositories.AccountRepository;
import fr.formation.loueunartiste.repositories.ArtistRepository;
import fr.formation.loueunartiste.security.SecurityHelper;

public class MediumAndFormatIsSetValidator
	implements ConstraintValidator<MediumAndFormatIsSet, Boolean> {

    private final AccountRepository accounts;
    private final ArtistRepository artists;

    public MediumAndFormatIsSetValidator(AccountRepository accounts,
	    ArtistRepository artists) {
	this.accounts = accounts;
	this.artists = artists;
    }

    @Override
    public boolean isValid(Boolean available,
	    ConstraintValidatorContext context) {
	Long accountId = SecurityHelper.accountId();
	Artist artistEntity = artists
		.findByAccount(accounts.findById(accountId));

	if (!artistEntity.getArtMedium().isEmpty()
		&& !artistEntity.getArtFormat().isEmpty()) {
	    return true;
	}
	return false;
    }

}
