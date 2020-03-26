package fr.diginamic.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.diginamic.entities.Livre;

public class TestJpa {

	public static void main(String[] args) {

		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("compta-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		TypedQuery <Livre> queryResult = em.createQuery("select l from Livre l where l.id = 1",Livre.class);
		
		System.out.println("------------Recherche par id------------");
		
		Livre leLivre = queryResult.getSingleResult();
		System.out.println("Le livre obtenue a l'id : " + leLivre.getId()
		+ " Titre : " + leLivre.getTitre()
		+ "Auteur : " + leLivre.getAuteur());
		
		System.out.println("------------Recherche par nom------------");

		queryResult = em.createQuery("select l from Livre l where l.titre = 'Vingt mille lieues sous les mers'",Livre.class);
		leLivre = queryResult.getSingleResult();
		System.out.println("Le livre obtenue a l'id : " + leLivre.getId()
		+ " Titre : " + leLivre.getTitre()
		+ "Auteur : " + leLivre.getAuteur());
		
		em.close();
		entityManagerFactory.close();
	}

}
