package org.example;

import javax.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int CompanyID;

    private String CompanyName;
    private String Street;
    private String City;
    private String ZipCode;

    public Company(){};

    public Company(String companyName, String street, String city, String zipCode){
        this.City = city;
        this.CompanyName = companyName;
        this.ZipCode = zipCode;
        this.Street = street;
    }

    public String getCompanyName() {
        return CompanyName;
    }
}
