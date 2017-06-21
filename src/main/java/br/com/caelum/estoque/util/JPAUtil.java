package br.com.caelum.estoque.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by nando on 19/06/17.
 */
public class JPAUtil {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("estoque");

    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

}
