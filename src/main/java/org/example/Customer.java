package org.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer extends Company {
    private double Discount;

    public Customer(){};

    public Customer(String companyName, String street, String city, String zipCode, double discount){
        super(companyName, street, city, zipCode);
        this.Discount = discount;
    }


}
