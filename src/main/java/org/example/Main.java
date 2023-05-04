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


        final Session session = getSession();

        try {
            Transaction tx = session.beginTransaction();

            Query query = session.createQuery("from Category ");
            List<Category> categoryList = query.getResultList();
            for (Category c: categoryList) {
                System.out.println(c.getName());
                for (Product p: c.getProducts()) {
                    System.out.println(p.getProductName());
                }


            }

            tx.commit();
        } finally {
            session.close();
        }



    }
}

