package com.compit.hibernate.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRIES")
public class Countries {

    @Id
    @Column (name = "COUNTRY_ID")
    private String countryID;

    @Column (name = "COUNTRY_NAME")
    private String countryName;

    @Column (name = "REGION_ID")
    private String regionID;


    /* getters and setters*/

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getRegionID() {
        return regionID;
    }

    public void setRegionID(String regionID) {
        this.regionID = regionID;
    }

    /*toString() method*/
}
