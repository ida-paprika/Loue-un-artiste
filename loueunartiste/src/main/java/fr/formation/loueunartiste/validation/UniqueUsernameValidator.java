package fr.formation.loueunartiste.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.formation.loueunartiste.repositories.UserRepository;

public class UniqueUsernameValidator
	implements ConstraintValidator<UniqueUsername, String> {

    private final UserRepository users;

    public UniqueUsernameValidator(UserRepository users) {
	super();
	this.users = users;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
	if (username == null) {
	    return true;
	}

	return !users.existsByUsername(username);
    }

}
