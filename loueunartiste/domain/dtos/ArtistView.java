package fr.formation.loueunartiste.domain.dtos;

import java.util.List;

public class ArtistView {

    private String artistName;
    private String portfolioUrl;
    private boolean available;
    private List<String> artMedium;
    private List<String> artFormat;

    public ArtistView() {
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

    public boolean isAvailable() {
	return available;
    }

    public void setAvailable(boolean available) {
	this.available = available;
    }

    public List<String> getArtMedium() {
	return artMedium;
    }

    public void setArtMedium(List<String> artMedium) {
	this.artMedium = artMedium;
    }

    public List<String> getArtFormat() {
	return artFormat;
    }

    public void setArtFormat(List<String> artFormat) {
	this.artFormat = artFormat;
    }

    @Override
    public String toString() {
	return "ArtistView [artistName=" + artistName + ", portfolioUrl="
		+ portfolioUrl + ", available=" + available + ", artMedium="
		+ artMedium + ", artFormat=" + artFormat + "]";
    }

}
