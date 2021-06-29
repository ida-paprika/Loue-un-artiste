package fr.formation.loueunartiste.domain.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Project extends AbstractEntity {

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "description")
    private String description;

    @Column(name = "deadline")
    private LocalDate deadline;

    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account client;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    public Project() {
	//
    }

    public LocalDateTime getCreatedDate() {
	return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
	this.createdDate = createdDate;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public LocalDate getDeadline() {
	return deadline;
    }

    public void setDeadline(LocalDate deadline) {
	this.deadline = deadline;
    }

    public Integer getPrice() {
	return price;
    }

    public void setPrice(Integer price) {
	this.price = price;
    }

    public Artist getArtist() {
	return artist;
    }

    public void setArtist(Artist artist) {
	this.artist = artist;
    }

    public Account getClient() {
	return client;
    }

    public void setClient(Account client) {
	this.client = client;
    }

    public Status getStatus() {
	return status;
    }

    public void setStatus(Status status) {
	this.status = status;
    }

    @Override
    public String toString() {
	return "Project [createdDate=" + createdDate + ", description="
		+ description + ", deadline=" + deadline + ", price=" + price
		+ ", artist=" + artist + ", client=" + client + ", status="
		+ status + "]";
    }

}
