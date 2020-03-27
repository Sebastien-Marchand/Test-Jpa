package fr.diginamic.banque;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.banque.entities.Adresse;
import fr.diginamic.banque.entities.Banque;
import fr.diginamic.banque.entities.Client;
import fr.diginamic.banque.entities.Compte;
import fr.diginamic.banque.entities.Operation;

public class TestBanque {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Banque banque1 = new Banque("banque1");

		Client client1 = new Client("Renou", "Antoine", LocalDate.now(), banque1, new Adresse(5, "rue de nantes", "Nantes"));

		Compte compte1 = new Compte(Arrays.asList(client1));
		Operation ope1 = new Operation(LocalDate.now(), 200.0,"Credit",compte1);
		
		client1.addCompte(compte1);
		compte1.addOperation(ope1);
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
