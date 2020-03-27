package fr.diginamic.entities;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "EMPRUNT")

public class Emprunt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "ID")
	private int id;
	
	@Column(name = "DELAI")
	int delai;
	@Column(name = "DATE_DEBUT")
	private Date date_debut;
	@Column(name = "DATE_FIN")
	private Date date_fin;
	

	@ManyToOne
	@JoinColumn(name = "ID_CLIENT")
	Client id_client;
	
	@ManyToMany
	@JoinTable(name = "compo", joinColumns = @JoinColumn(name = "ID_EMP",
	referencedColumnName = "ID"),
	inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"))
	private Set<Livre> livres;


	public Emprunt() {
	}

	public Emprunt(int id, int delai, Date date_debut, Date date_fin, Client id_client, Set<Livre> livres) {

		this.id = id;
		this.delai = delai;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.id_client = id_client;
		this.livres = livres;
	}



	/**Getter
	 * @return the id_client
	 */
	public Client getId_client() {
		return id_client;
	}
	/**Getter
	 * @return the livres
	 */
	public Set<Livre> getLivres() {
		return livres;
	}
}
