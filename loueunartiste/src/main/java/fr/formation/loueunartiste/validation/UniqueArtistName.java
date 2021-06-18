package fr.formation.loueunartiste.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = { UniqueArtistNameValidator.class })
public @interface UniqueArtistName {
    String message() default "Ce nom est déjà utilisé";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
