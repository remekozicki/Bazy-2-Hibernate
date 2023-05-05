//package org.example;
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//public class Product {
//    @Id
//    @GeneratedValue (strategy = GenerationType.AUTO)
//    private int dbID;
//
//    private String ProductName;
//    private Integer UnitsOnStock;
//
//    @ManyToOne
//    @JoinColumn (name = "SUPPLIER_FK")
//    private Supplier supplier;
//
//    @ManyToMany(mappedBy = "sellProducts", cascade = {CascadeType.PERSIST})
//    private Set<Invoice> Invoices;
//
//
//    public Product(){}
//
//    public Product(String productName, Integer unitsOnStock){
//        this.ProductName = productName;
//        this.UnitsOnStock = unitsOnStock;
//        this.Invoices = new HashSet<>();
//    }
//
//    public void addInvoices(Invoice invoice) {
//        this.Invoices.add(invoice);
//    }
//
//    public String getProductName() {
//        return ProductName;
//    }
//
//    public Integer getUnitsOnStock() {
//        return UnitsOnStock;
//    }
//
//
//
//    public Set<Invoice> getInvoices() {
//        return Invoices;
//    }
//}
