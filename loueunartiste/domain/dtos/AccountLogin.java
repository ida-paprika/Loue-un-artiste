package fr.formation.loueunartiste.domain.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class AccountLogin {

    @NotEmpty
    @NotBlank
    private String username;

    @NotEmpty
    @NotBlank
    private String password; // will be crypted

    public AccountLogin() {
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
	return "AccountLogin [username=" + username + ", password=PROTECTED]";
    }

}
