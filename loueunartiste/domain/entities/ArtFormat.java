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

    public List<Artist> getArtist() {
	return artist;
    }

    public void setArtist(List<Artist> artist) {
	this.artist = artist;
    }

    @Override
    public String toString() {
	return "ArtFormat [label=" + label + "]";
    }

}
