package fr.formation.loueunartiste.domain.dtos;

import fr.formation.loueunartiste.validation.MediumAndFormatIsSet;

public class ArtistAvailableUpdate {

    @MediumAndFormatIsSet
    private boolean available;

    public ArtistAvailableUpdate() {
    }

    public boolean isAvailable() {
	return available;
    }

    public void setAvailable(boolean available) {
	this.available = available;
    }

    @Override
    public String toString() {
	return "ArtistAvailableUpdate [available=" + available + "]";
    }

}
