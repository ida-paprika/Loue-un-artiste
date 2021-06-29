package fr.formation.loueunartiste.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status extends AbstractEntity {

    @Column(name = "label")
    private String label;

    public Status() {
	//
    }

    public String getLabel() {
	return label;
    }

    public void setLabel(String label) {
	this.label = label;
    }

    @Override
    public String toString() {
	return "Status [label=" + label + "]";
    }

}
