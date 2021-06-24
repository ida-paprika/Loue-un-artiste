package fr.formation.loueunartiste.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.formation.loueunartiste.repositories.AccountRepository;

public class UniqueUsernameValidator
	implements ConstraintValidator<UniqueUsername, String> {

    private final AccountRepository accounts;

    public UniqueUsernameValidator(AccountRepository accounts) {
	super();
	this.accounts = accounts;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
	if (username == null) {
	    return true;
	}

	return !accounts.existsByUsername(username);
    }

}
