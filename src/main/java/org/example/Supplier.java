package org.example;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Supplier {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)

    private int ID;

    private String CompanyName;
    private String Street;
    private String City;
    @OneToMany
//    @JoinColumn (name = "SUPPLIER_FK")
    private Set<Product> productsGroup;

    public Supplier(){}

    public Supplier(String companyName, String street, String city){
        this.CompanyName = companyName;
        this.Street = street;
        this.City = city;
        this.productsGroup = new HashSet<>();

    }

    public void setStreet(String street) {
        Street = street;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public void addProductToProductGroup(Product product){
        this.productsGroup.add(product);
    }
}
