package fr.formation.loueunartiste.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends AbstractEntity {

    @Column(name = "code")
    private String code;

    public Role() {
	//
    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    @Override
    public String toString() {
	return "Role ----- id = " + getId() + "\n[ code= " + code + " ]";
    }

}
