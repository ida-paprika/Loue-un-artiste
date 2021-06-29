package fr.formation.loueunartiste.domain.dtos;

public class ProjectArtistView {

    private Long artistId;
    private String artistName;
    private String portfolioUrl;
    private int minimumPrice;

    public ProjectArtistView() {
	//
    }

    public Long getArtistId() {
	return artistId;
    }

    public void setArtistId(Long artistId) {
	this.artistId = artistId;
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

    public int getMinimumPrice() {
	return minimumPrice;
    }

    public void setMinimumPrice(int minimumPrice) {
	this.minimumPrice = minimumPrice;
    }

    @Override
    public String toString() {
	return "ProjectArtistView [artistId=" + artistId + ", artistName="
		+ artistName + ", portfolioUrl=" + portfolioUrl
		+ ", minimumPrice=" + minimumPrice + "]";
    }

}
