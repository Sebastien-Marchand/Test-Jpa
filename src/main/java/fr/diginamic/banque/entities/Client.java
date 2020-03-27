package fr.diginamic.banque.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table ( name = "CLIENT")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name = "NOM")
	String nom;
	@Column(name = "PRENOM")
	String prenom;
	@Column(name = "DATENAISSANCE")
	LocalDate dateNaissance;
	
	@ManyToMany
	@JoinTable(name = "Compte_client", joinColumns = @JoinColumn(name = "ID_CLIENT",
	referencedColumnName = "ID"),
	inverseJoinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "ID"))
	private Set<Compte> comptes;
	
	@Column(name = "ID_BANQUE")
	@OneToOne
	private Banque id_banque;
	
	@Column(name = "ADRESSE")
	@Embedded
	private Adresse adresse;

	@Embeddable
	public class Adresse {
		private Integer numero;
		private String rue;
		private String ville;
	}

}
