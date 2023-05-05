package org.example;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Supplier extends Company {

//    @OneToMany
//    private Set<Product> productsGroup =new HashSet<>();

    private String bankAccountNumber;

    public Supplier(){}

    public Supplier(String companyName, String street, String city, String zipCode, String bankAccountNumber) {
        super(companyName, street, city, zipCode);
        this.bankAccountNumber = bankAccountNumber;

    }
}
