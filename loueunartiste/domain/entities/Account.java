package fr.formation.loueunartiste.domain.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account extends AbstractEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "enabled")
    private boolean enabled;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Account() {
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

    public LocalDateTime getRegistrationDate() {
	return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
	this.registrationDate = registrationDate;
    }

    public boolean isEnabled() {
	return enabled;
    }

    public void setEnabled(boolean activated) {
	this.enabled = activated;
    }

    public Role getRole() {
	return role;
    }

    public void setRole(Role role) {
	this.role = role;
    }

    @Override
    public String toString() {
	return "Account ----- \n[username= " + username + " ] [password= "
		+ password + " ]\n[registrationDate= " + registrationDate
		+ " ] [enabled= " + enabled + " ]\n[role= " + role + " ] -----";
    }

}
