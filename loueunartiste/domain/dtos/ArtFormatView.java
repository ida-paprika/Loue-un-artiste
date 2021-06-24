package fr.formation.loueunartiste.domain.dtos;

public class ArtFormatView {

    private Long id;

    private String label;

    public ArtFormatView() {
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
	return "ArtFormatView [id=" + id + ", label=" + label + "]";
    }

}
