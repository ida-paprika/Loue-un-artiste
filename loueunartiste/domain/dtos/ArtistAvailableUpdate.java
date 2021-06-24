package fr.formation.loueunartiste.domain.dtos;

public class ArtistAvailableUpdate {

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
