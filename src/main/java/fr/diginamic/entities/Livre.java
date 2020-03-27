package fr.diginamic.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "LIVRE")

public class Livre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titre;
	private String auteur;
	
	@ManyToMany(mappedBy="livres")
	private Set<Emprunt> emprunts;
	
	public Livre()
	{
		
	}
	public Livre(int id) {
		super();
		this.id = id;
	}
	
	public Livre(int id, String titre) {
		super();
		this.id = id;
		this.titre = titre;
	}
	
	public Livre(int id, String titre, String auteur) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
	}

	public Livre(int id, String titre, String auteur, Set<Emprunt> emprunts) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.emprunts = emprunts;
	}
	/**Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**Getter
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}
	/**Getter
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}
	@Override
	public String toString()
	{
		return "Livre : " + this.titre + " Auteur : " + this.auteur + " Id : " + this.id;
	}
}
