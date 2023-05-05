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

        Customer custmer1 = new Customer("Blachy Jurka", "Malinowa", "Warszawa", "12-120", 0.2);
        Customer custmer2 = new Customer("Wykonczenówka", "Pomidorowa", "Warszawa", "13-130", 0.1);
        Customer custmer3 = new Customer("BOSS", "Wesoła", "Warszawa", "14-140", 0.15);

        Supplier supplier1 = new Supplier("hurtBlachy", "Hurtowa", "Wrocław", "10-100", "1234567890");
        Supplier supplier2 = new Supplier("hurtCegła", "Hurtowa", "Wrocław", "10-100", "1234567890");
        Supplier supplier3 = new Supplier("hurtKable", "Hurtowa", "Wrocław", "10-100", "1234567890");

        em.persist(custmer1);
        em.persist(custmer2);
        em.persist(custmer3);

        em.persist(supplier1);
        em.persist(supplier2);
        em.persist(supplier3);

        Supplier foundSupplier = (Supplier) em.find(Supplier.class, 4);
        System.out.println(foundSupplier.getCompanyName());

        Customer foundCustomer = (Customer) em.find(Customer.class, 1);
        System.out.println(foundCustomer.getCompanyName());

        etx.commit();
        em.close();
    }


}
