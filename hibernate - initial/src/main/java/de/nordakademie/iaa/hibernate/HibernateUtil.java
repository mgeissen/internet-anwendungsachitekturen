package de.nordakademie.iaa.hibernate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by stefan on 08/08/15.
 */
public class HibernateUtil {

    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("NAK_DB");

    private HibernateUtil(){
        // private constructor to avoid instatiation
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return EMF;
    }
}
