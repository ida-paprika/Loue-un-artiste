package fr.formation.loueunartiste.domain.entities;

import java.util.Set;

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
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "artist_name")
    private String artistName;

    @Column(name = "portfolio_url")
    private String portfolioUrl;

    @ManyToMany
    @JoinTable(name = "artists_art_formats", joinColumns = @JoinColumn(name = "artist_id"), inverseJoinColumns = @JoinColumn(name = "art_format_id"))
    private Set<ArtFormat> artFormat;

    @ManyToMany
    @JoinTable(name = "artists_art_mediums", joinColumns = @JoinColumn(name = "artist_id"), inverseJoinColumns = @JoinColumn(name = "art_medium_id"))
    private Set<ArtMedium> artMedium;

    public Artist() {
	//
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public String getArtistName() {
	return artistName;
    }

    public Set<ArtFormat> getArtFormat() {
	return artFormat;
    }

    public void setArtFormat(Set<ArtFormat> artFormat) {
	this.artFormat = artFormat;
    }

    public Set<ArtMedium> getArtMedium() {
	return artMedium;
    }

    public void setArtMedium(Set<ArtMedium> artMedium) {
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

    @Override
    public String toString() {
	return "Artist [user=" + user + ", artistName=" + artistName
		+ ", portfolioUrl=" + portfolioUrl + ", artFormat=" + artFormat
		+ ", artMedium=" + artMedium + "]";
    }

}
