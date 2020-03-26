package fr.diginamic.entities;

import javax.persistence.*;
@Entity
@Table(name = "LIVRE")

public class Livre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titre;
	private String auteur;
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
}
