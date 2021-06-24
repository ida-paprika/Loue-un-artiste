package fr.formation.loueunartiste.domain.dtos;

import java.util.List;

import javax.validation.constraints.NotEmpty;

public class MediumAndFormatCreate {

    @NotEmpty
    private List<Long> artMediumId;

    @NotEmpty
    private List<Long> artFormatId;

    public MediumAndFormatCreate() {
    }

    public List<Long> getArtMediumId() {
	return artMediumId;
    }

    public void setArtMediumId(List<Long> artMediumId) {
	this.artMediumId = artMediumId;
    }

    public List<Long> getArtFormatId() {
	return artFormatId;
    }

    public void setArtFormatId(List<Long> artFormatId) {
	this.artFormatId = artFormatId;
    }

    @Override
    public String toString() {
	return "MediumAndFormatCreate [artMediumId=" + artMediumId
		+ ", artFormatId=" + artFormatId + "]";
    }

}
