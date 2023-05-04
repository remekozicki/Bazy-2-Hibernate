package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainJPA {


    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("RemigiuszKozickiJPAConfig");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();

        Product product1 = new Product("Kapusta", 10);
        Product product2 = new Product("Groch", 11);
        Product product3 = new Product("Gruszka", 12);
        Product product4 = new Product("Avokado", 13);
        Product product5 = new Product("Sliwka", 14);
        Product product6 = new Product("Pyra", 15);
        Product product7 = new Product("Pomidor", 16);
        Product product8 = new Product("Banan", 17);
        Invoice invoice1 = new Invoice(1, 5);
        Invoice invoice2 = new Invoice(2,10);

        em.persist(product1);
        em.persist(product2);
        em.persist(product3);
        em.persist(product4);
        em.persist(product5);
        em.persist(product6);
        em.persist(product7);
        em.persist(product8);

        em.persist(invoice1);
        em.persist(invoice2);

        invoice1.sellProduct(product1);
        invoice1.sellProduct(product2);
        invoice1.sellProduct(product5);

        invoice2.sellProduct(product3);
        invoice2.sellProduct(product4);
        invoice2.sellProduct(product6);

        product1.addInvoices(invoice1);
        product2.addInvoices(invoice1);
        product5.addInvoices(invoice1);

        product3.addInvoices(invoice2);
        product4.addInvoices(invoice2);
        product6.addInvoices(invoice2);

        Invoice foundInvoice = (Invoice) em.find(Invoice.class, 1);
        System.out.println("Produkty z faltury" + foundInvoice.toString());
        for (Product p: foundInvoice.getProducts()) {
            System.out.println(p.getProductName());
        }

        Product foundProduct = (Product) em.find(Product.class,11);
        System.out.println("Gdzie występuje produkty " + foundProduct.getProductName());
        for (Invoice i: foundProduct.getInvoices()) {
            System.out.println(i.toString());
        }

        etx.commit();
        em.close();
    }


}
