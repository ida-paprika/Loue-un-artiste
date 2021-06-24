package fr.formation.loueunartiste.domain.dtos;

import java.util.List;

public class ContactArtistCreate {

    private String artistName;
    private List<ArtMediumView> artistMediumList;
    private List<ArtFormatView> artistFormatList;

    public ContactArtistCreate() {
	//
    }

    public String getArtistName() {
	return artistName;
    }

    public void setArtistName(String artistName) {
	this.artistName = artistName;
    }

    public List<ArtMediumView> getArtistMediumList() {
	return artistMediumList;
    }

    public void setArtistMediumList(List<ArtMediumView> artistMediumList) {
	this.artistMediumList = artistMediumList;
    }

    public List<ArtFormatView> getArtistFormatList() {
	return artistFormatList;
    }

    public void setArtistFormatList(List<ArtFormatView> artistFormatList) {
	this.artistFormatList = artistFormatList;
    }

    @Override
    public String toString() {
	return "ContactArtistCreate [artistName=" + artistName
		+ ", artistMediumList=" + artistMediumList
		+ ", artistFormatList=" + artistFormatList + "]";
    }

}
