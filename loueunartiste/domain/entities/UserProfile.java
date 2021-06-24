package fr.formation.loueunartiste.domain.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_profiles")
public class UserProfile extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "avatar")
    private String avatar;

    public UserProfile() {
	//
    }

    public Account getAccount() {
	return account;
    }

    public void setAccount(Account account) {
	this.account = account;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getPhoneNumber() {
	return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
	return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
	this.birthDate = birthDate;
    }

    public String getAvatar() {
	return avatar;
    }

    public void setAvatar(String avatar) {
	this.avatar = avatar;
    }

    @Override
    public String toString() {
	return "UserProfile [account=" + account.getUsername() + ", email="
		+ email + ", firstName=" + firstName + ", lastName=" + lastName
		+ ", phoneNumber=" + phoneNumber + ", birthDate=" + birthDate
		+ ", avatar=" + avatar + "]";
    }

}
