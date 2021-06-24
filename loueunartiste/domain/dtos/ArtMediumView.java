package fr.formation.loueunartiste.domain.dtos;

public class ArtMediumView {

    private Long id;

    private String label;

    public ArtMediumView() {
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getLabel() {
	return label;
    }

    public void setLabel(String label) {
	this.label = label;
    }

    @Override
    public String toString() {
	return "ArtMediumView [id=" + id + ", label=" + label + "]";
    }

}
