package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;
import java.util.Objects;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
//        Product product1 = new Product("Flamaster", 400);
//        Product product2 = new Product("Kredka", 100);
//        Product product3 = new Product("Linijka", 1000);
//        Supplier supplier = new Supplier("KredkaPol", "Papiernicza", "Warszawa");
//        Category category = new Category(3, "Przybory Szkolne");



        final Session session = getSession();

        try {
            Transaction tx = session.beginTransaction();

            String hql = "select ProductName from  Product P join Category C on P.C = C.CategoryID";
            Query q = session.createQuery(hql);
            List<String> list  = q.getResultList();
            for (String s: list){
                System.out.println(s);
            }


            tx.commit();
        } finally {
            session.close();
        }



    }
}