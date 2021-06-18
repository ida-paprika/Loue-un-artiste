package fr.formation.loueunartiste.domain.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import fr.formation.loueunartiste.validation.UniqueArtistName;
import fr.formation.loueunartiste.validation.UniqueUsername;

public class ArtistCreate {

    @NotEmpty
    @NotBlank
    @Size(min = 2, max = 50)
    @UniqueArtistName
    private String artistName;

    @NotEmpty
    @NotBlank
    @Size(max = 100)
    private String portfolioUrl;

    @NotEmpty
    @NotBlank
    @Size(max = 50)
    @Email // Make a custom email validation
    @UniqueUsername
    private String username;// insert into users + socialInfos "email"

    @NotEmpty
    @NotBlank
    @Size(min = 8, max = 12)
    private String password;// insert into users

    public ArtistCreate() {
	//
    }

    public String getArtistName() {
	return artistName;
    }

    public void setArtistName(String artistName) {
	this.artistName = artistName;
    }

    public String getPortfolioUrl() {
	return portfolioUrl;
    }

    public void setPortfolioUrl(String portfolioUrl) {
	this.portfolioUrl = portfolioUrl;
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
	return "ArtistCreate [artistName=" + artistName + ", firstName="
		+ ", portfolioUrl=" + portfolioUrl + ", username=" + username
		+ ", password=" + password + "]";
    }

}
