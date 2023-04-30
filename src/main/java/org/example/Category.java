package org.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    private int CategoryID;
    private String Name;

    @OneToMany  // jest wymagane
    @JoinColumn (name = "CATEGORY_FK")
    private List<Product> Products;

    public Category(){}

    public Category (int categoryID, String name) {
        this.CategoryID = categoryID;
        this.Name = name;
        this.Products = new ArrayList<>();

    }

    public void setProducts(Product product) {
        Products.add(product);
    }
}
