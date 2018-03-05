package fr.futurskill.tutorial.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.futurskill.tutorial.jpa.model.Account;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AccountTest {
	
	private static EntityManagerFactory emf;
	
	@BeforeClass
	public static void initEMF() {
		System.out.println("Init EMF");
		// Initialise une connextion en utilisant l'unité de persistence h2
		emf = Persistence.createEntityManagerFactory("h2");
	}

	@AfterClass
	public static void closeEMF() {
		System.out.println("Close EMF");
		emf.close();
	}
	
	EntityManager em;
	EntityTransaction transaction;
	
	@Before
	public void initEM() {
		System.out.println("++++ Init EM");
		// Créer une instance de EntityManager
		em = emf.createEntityManager();

		transaction = em.getTransaction();
		
		// Début de transaction
		transaction.begin();
		
	}
	
	@After
	public void closeEM() {
		System.out.println("++++ Close EM");
		transaction.commit();
		em.close();
	}
	
	/**
	 * Valide l'ensemble JPA : modèle, persistence.xml (provider, jdbc, paramètre de la bdd)
	 */
	@Test
	public void ajout() {
		System.out.println("Test ajout");
		// Connection à la base de données
		// Utilise les informations de persistence.xml
		


		// Création d'un nouveau compte en BDD
		Account account = new Account();

		account.setFirstName("Laurent");
		account.setLastName("Joyeux");
		account.setLogin("ljoyeux@devlogic.fr");

		// Ne pas fixer l'identifiant
		// account.setId(2);

		assert account.getId() == 0;
		
		/*
		Faire les opérations en bdd
		*/

		// ajouter account à la bdd
//		em.persist(account);
		
		// similaire à em.persist, retourne l'objet de la bdd
		account = em.merge(account);
		assert account.getId()!=0;
		System.out.println("id: " + account.getId());
	}

	@Test
	public void read() {
		System.out.println("Test read");
//		Ne fonctionne pas
//		Langage SQL
//		List<Account> results = em.createQuery("SELECT * FROM ACCOUNT").getResultList();

// 	Transformation : 
//		Nom table -> nom classe (ACCOUNT -> Account)
//		* -> Nom de variable
//						
// 		Langage JPL (similaire à SQL)
// 		NC : nom classe
//		V : nom de variable
//                                                     V        NC    V
		@SuppressWarnings("unchecked")
		List<Account> results = em.createQuery("SELECT a FROM Account a").getResultList();
		
		System.out.println(results.getClass().getName());
		
		for(Account account: results) {
			System.out.println(account);
		}
		
		
		System.out.println("SELECT WHERE id=5");
		results = em.createQuery("SELECT a FROM Account a WHERE a.id=5").getResultList();
		for(Account account: results) {
			System.out.println(account);
		}
		
		System.out.println("SELECT WHERE id=6 par paramètre");
		long id = 6;
		// Paramètre id préfixé par ":" dans la requête
		// On affecte le paramètre par la méthode setParameter
		results = em.createQuery("SELECT a FROM Account a WHERE a.id=:id")
					.setParameter("id", id)
					.getResultList();
		for(Account account: results) {
			System.out.println(account);
		}
	}
	
	
	@Test
	public void updateV1() {
		// Etape 1: vérifier que l'enregistrement est BDD

		long id = 6;
		List<Account> results = em.createQuery("SELECT a FROM Account a WHERE a.id=:id")
					.setParameter("id", id)
					.getResultList();
		
		if (!results.isEmpty()) {
			// Etape 2: faire la modification de l'enregistrement
			em.createQuery("UPDATE Account a SET a.lastName=:lastName WHERE a.id=:id")
			  .setParameter("lastName", "sdfsdgd")
			  .setParameter("id", id).executeUpdate();
			
			// validation des modifications.
			transaction.commit();
			em.close();
			
			// création d'une nouvelle EM
			em = emf.createEntityManager();
			transaction = em.getTransaction();
			Account account = (Account) em.createQuery("SELECT a FROM Account a WHERE a.id=:id")
					.setParameter("id", id)
					.getSingleResult();
			
			System.out.println("Updated lastName");
			System.out.println(account);
		}
	}
	
	@Test
	public void updateV2() {
		// Etape 1: vérifier que l'enregistrement est BDD

		long id = 7;
		List<Account> results = em.createQuery("SELECT a FROM Account a WHERE a.id=:id")
					.setParameter("id", id)
					.getResultList();
		
		if (!results.isEmpty()) {
			Account account = results.get(0);
			account.setFirstName("sdfdgd");
			em.merge(account);
		}
	}
	
}
