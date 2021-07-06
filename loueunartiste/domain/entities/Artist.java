package fr.formation.loueunartiste.domain.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "artists")
public class Artist extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "artist_name")
    private String artistName;

    @Column(name = "portfolio_url")
    private String portfolioUrl;

    @Column(name = "available")
    private boolean available;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "artists_art_mediums", joinColumns = @JoinColumn(name = "artist_id"), inverseJoinColumns = @JoinColumn(name = "art_medium_id"))
    private List<ArtMedium> artMedium;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "artists_art_formats", joinColumns = @JoinColumn(name = "artist_id"), inverseJoinColumns = @JoinColumn(name = "art_format_id"))
    private List<ArtFormat> artFormat;

    public Artist() {
	//
    }

    public Account getAccount() {
	return account;
    }

    public void setAccount(Account account) {
	this.account = account;
    }

    public String getArtistName() {
	return artistName;
    }

    public List<ArtFormat> getArtFormat() {
	return artFormat;
    }

    public void setArtFormat(List<ArtFormat> artFormat) {
	this.artFormat = artFormat;
    }

    public List<ArtMedium> getArtMedium() {
	return artMedium;
    }

    public void setArtMedium(List<ArtMedium> artMedium) {
	this.artMedium = artMedium;
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

    public boolean isAvailable() {
	return available;
    }

    public void setAvailable(boolean available) {
	this.available = available;
    }

    @Override
    public String toString() {
	return "Artist [account=" + account.getUsername() + ", artistName="
		+ artistName + ", portfolioUrl=" + portfolioUrl + ", available="
		+ available + ", artMedium=" + artMedium + ", artFormat="
		+ artFormat + "]";
    }

}
