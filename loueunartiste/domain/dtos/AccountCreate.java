package fr.formation.loueunartiste.domain.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import fr.formation.loueunartiste.validation.UniqueUsername;

public class AccountCreate {

    @NotEmpty
    @NotBlank
    @Size(max = 50)
    @Email
    @UniqueUsername
    private String username;

    @NotEmpty
    @NotBlank
    @Size(min = 8, max = 12)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]+$", message = "doit contenir au moins une minuscule, une majuscule et un chiffre")
    private String password;

    public AccountCreate() {
	//
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    @Override
    public String toString() {
	return "New Account--------\n[ username = " + username
		+ "]\n[ password = PROTECTED ]\n--------";
    }

}
