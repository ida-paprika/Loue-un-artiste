package fr.formation.loueunartiste.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address extends AbstractEntity {

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "address_supplement")
    private String addressSupplement;

    @Column(name = "postal_code")
    private Integer postalCode;

    /* FAIRE APPEL A TABLE EXTERNE (codes postaux -> villes) */
    @Column(name = "city")
    private String city;

    public Address() {
	//
    }

    public String getStreetNumber() {
	return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
	this.streetNumber = streetNumber;
    }

    public String getStreetName() {
	return streetName;
    }

    public void setStreetName(String streetName) {
	this.streetName = streetName;
    }

    public String getAddressSupplement() {
	return addressSupplement;
    }

    public void setAddressSupplement(String addressSupplement) {
	this.addressSupplement = addressSupplement;
    }

    public Integer getPostalCode() {
	return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
	this.postalCode = postalCode;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    @Override
    public String toString() {
	return "Address [streetNumber=" + streetNumber + ", streetName="
		+ streetName + ", addressSupplement=" + addressSupplement
		+ ", postalCode=" + postalCode + ", city=" + city + "]";
    }

}
