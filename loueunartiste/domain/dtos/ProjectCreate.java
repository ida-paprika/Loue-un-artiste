package fr.formation.loueunartiste.domain.dtos;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProjectCreate {

    @NotEmpty
    @NotBlank
    private Long mediumId;

    @NotEmpty
    @NotBlank
    private Long formatId;

    @NotNull
    @Future
    private LocalDate deadline;

    @NotEmpty
    @NotBlank
    @Size(min = 20, max = 250)
    private String description;

    public ProjectCreate() {
	//
    }

    public Long getMediumId() {
	return mediumId;
    }

    public void setMediumId(Long mediumId) {
	this.mediumId = mediumId;
    }

    public Long getFormatId() {
	return formatId;
    }

    public void setFormatId(Long formatId) {
	this.formatId = formatId;
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
	return "ProjectCreate [mediumId=" + mediumId + ", formatId="
		+ formatId + ", deadline=" + deadline + ", description="
		+ description + "]";
    }

}
