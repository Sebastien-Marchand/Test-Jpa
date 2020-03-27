package fr.diginamic.app;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.diginamic.entities.Emprunt;
import fr.diginamic.entities.Livre;

public class TestJpa {

	public static void main(String[] args) {

		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("compta-jpa");
		EntityManager em = entityManagerFactory.createEntityManager();
		TypedQuery <Livre> queryResult = em.createQuery("select l from Livre l where l.id = 1",Livre.class);
		
		
		Livre leLivre = queryResult.getSingleResult();
		System.out.println("------------Recherche livre par id------------");

		System.out.println("Le livre obtenue a l'id : " + leLivre.getId()
		+ " Titre : " + leLivre.getTitre()
		+ "Auteur : " + leLivre.getAuteur());
		

		queryResult = em.createQuery("select l from Livre l where l.titre = 'Vingt mille lieues sous les mers'",Livre.class);
		leLivre = queryResult.getSingleResult();
		System.out.println("------------Recherche livre par nom------------");

		System.out.println("Le livre obtenue a l'id : " + leLivre.getId()
		+ " Titre : " + leLivre.getTitre()
		+ "Auteur : " + leLivre.getAuteur());
		
		TypedQuery <Emprunt> queryResultemprunt = em.createQuery("select e from Emprunt e ",Emprunt.class);
		List <Emprunt> empruntResultats = queryResultemprunt.getResultList();
		Set<Livre> listeLivreEmprunt = empruntResultats.get(0).getLivres();
		
		System.out.println("------------extraire un emprunt ------------");

		for(Livre leLivreEmprunt : listeLivreEmprunt)
		{
			System.out.println("Le livre obtenue : " +leLivreEmprunt);
		}
		
		queryResultemprunt = em.createQuery("select e from Emprunt e where ID_CLIENT = 3",Emprunt.class);
		empruntResultats = queryResultemprunt.getResultList();
		listeLivreEmprunt = empruntResultats.get(0).getLivres();
		
		System.out.println("------------extraire un emprunt d'un client précis------------");

		for(Livre leLivreEmprunt : listeLivreEmprunt)
		{
			System.out.println("Le livre obtenue : " +leLivreEmprunt);
		}
		
		em.close();
		entityManagerFactory.close();
	}

}
