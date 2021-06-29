package fr.formation.loueunartiste.domain.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "art_formats")
public class ArtFormat extends AbstractEntity {

    @Column(name = "label")
    private String label;

    @Column(name = "minimum_price")
    private int minimumPrice;

    @ManyToMany(mappedBy = "artFormat")
    private List<Artist> artist;

    public ArtFormat() {
	//
    }

    public String getLabel() {
	return label;
    }

    public void setLabel(String label) {
	this.label = label;
    }

    public int getMinimumPrice() {
	return minimumPrice;
    }

    public void setMinimumPrice(int minimumPrice) {
	this.minimumPrice = minimumPrice;
    }

    public List<Artist> getArtist() {
	return artist;
    }

    public void setArtist(List<Artist> artist) {
	this.artist = artist;
    }

    @Override
    public String toString() {
	return "ArtFormat [label=" + label + ", minimumPrice=" + minimumPrice
		+ ", artist=" + artist + "]";
    }

}
