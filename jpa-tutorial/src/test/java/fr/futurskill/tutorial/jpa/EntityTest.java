package fr.futurskill.tutorial.jpa;

import fr.futurskill.tutorial.jpa.model.Account;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EntityTest {

    private static EntityManagerFactory emf = null;

    @BeforeClass
    public static void initEMF() {
        emf = Persistence.createEntityManagerFactory("Futurskill-mysql_PU");
    }

    @AfterClass
    public static void closeEMF() {
        emf.close();
    }

    @Test
    public void dummy() {
        EntityManager em = emf.createEntityManager();
        em.close();
    }


    @Test
    public void add() {
        Account account = new Account();

        account.setFirstName("Laurent");
        account.setLastName("Joyeux");

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        account = em.merge(account);
        assert account.getId()!=0;
        transaction.commit();

        em.close();
    }
}
