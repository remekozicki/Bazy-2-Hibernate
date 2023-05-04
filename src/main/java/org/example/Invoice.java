package org.example;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Invoice {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int InvoiceNumber;
    private int Quantity;
    @ManyToMany
    Set<Product> sellProducts;

    public Invoice(){}

    public Invoice(int invoiceNumber,int quantity){
        this.Quantity = quantity;
        this.InvoiceNumber = invoiceNumber;
        this.sellProducts = new HashSet<>();
    }

    public void sellProduct(Product product){
        this.sellProducts.add(product);
    }

    public Set<Product> getProducts() {
        return sellProducts;
    }
}
