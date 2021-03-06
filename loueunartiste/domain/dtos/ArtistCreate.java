package fr.formation.loueunartiste.domain.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
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
    @Email
    @UniqueUsername
    private String username;

    @NotEmpty
    @NotBlank
    @Size(min = 8, max = 12)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]+$")
    private String password;

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
