package org.example;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int dbID;

    private String ProductName;
    private Integer UnitsOnStock;

    @ManyToOne
    @JoinColumn (name = "SUPPLIER_FK")
    private Supplier supplier;


    public Product(){}

    public Product(String productName, Integer unitsOnStock){
        this.ProductName = productName;
        this.UnitsOnStock = unitsOnStock;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public void setUnitsOnStock(Integer unitsOnStock) {
        UnitsOnStock = unitsOnStock;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
