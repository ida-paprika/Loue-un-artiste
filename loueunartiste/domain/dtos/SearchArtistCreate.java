package fr.formation.loueunartiste.domain.dtos;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SearchArtistCreate {

    @Valid
    private MediumAndFormatCreate mediumAndFormat;

    @NotNull
    @Future
    private LocalDate deadline;

    @NotEmpty
    @NotBlank
    @Size(min = 20, max = 250)
    private String description;

    public SearchArtistCreate() {
	//
    }

    public MediumAndFormatCreate getMediumAndFormat() {
	return mediumAndFormat;
    }

    public void setMediumAndFormat(MediumAndFormatCreate mediumAndFormat) {
	this.mediumAndFormat = mediumAndFormat;
    }

    public LocalDate getDeadline() {
	return deadline;
    }

    public void setDeadline(LocalDate deadline) {
	this.deadline = deadline;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    @Override
    public String toString() {
	return "SearchArtistCreate [mediumAndFormat=" + mediumAndFormat
		+ ", deadline=" + deadline + ", description=" + description
		+ "]";
    }

}
