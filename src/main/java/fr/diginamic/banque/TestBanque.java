package fr.diginamic.banque;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.*;

import fr.diginamic.banque.entities.Adresse;
import fr.diginamic.banque.entities.Banque;
import fr.diginamic.banque.entities.Client;
import fr.diginamic.banque.entities.Compte;
import fr.diginamic.banque.entities.Operation;

public class TestBanque {

	private static Logger LOGGER = Logger.getLogger(TestBanque.class.getName());

	
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Banque banque1 = new Banque("banque1");

		Client client1 = new Client("Renou", "Antoine", LocalDate.now(), banque1, new Adresse(5, "rue de nantes", "Nantes"));

		Compte compte1 = new Compte(Arrays.asList(client1));
		Compte livretA = new LivretA(1.0 , Arrays.asList(client1));
		Compte assuranceVie = new AssuranceVie(Arrays.asList(client1), LocalDate.now(), 2.0);

		
		Operation ope1 = new Operation(LocalDate.now(), 200.0,"Credit",compte1);
		
		client1.addCompte(compte1);
		compte1.addOperation(ope1);
		
		// transation
		EntityTransaction maTransaction = entityManager.getTransaction();
		maTransaction.begin();
		
		entityManager.persist(banque1);
		entityManager.persist(client1);
		Arrays.asList(compte1 , ope1 , livretA , assuranceVie).forEach(entityManager::persist);
		
		maTransaction.commit();
		
		TypedQuery<Compte> query3 = entityManager.createQuery("Select c FROM Compte c", Compte.class);

		for (Compte c : query3.getResultList()) {
			LOGGER.log(Level.INFO, c.toString());
		}
		entityManager.close();
		entityManagerFactory.close();
	}

}
