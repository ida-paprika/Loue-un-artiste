package fr.formation.loueunartiste.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = { MediumAndFormatIsSetValidator.class })
public @interface MediumAndFormatIsSet {
    String message() default "Au moins un médium et un format doivent être renseignés";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
