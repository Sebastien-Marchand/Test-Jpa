package fr.diginamic.banque.entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table ( name = "CLIENT")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "PRENOM")
	private String prenom;
	@Column(name = "DATENAISSANCE")
	private LocalDate dateNaissance;
	
	@ManyToMany
	@JoinTable(name = "Compte_client", joinColumns = @JoinColumn(name = "ID_CLIENT",
	referencedColumnName = "ID"),
	inverseJoinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "ID"))
	private Set<Compte> comptes;
	
	
	@ManyToOne
	@JoinColumn ( name = "ID_BANQUE")
	private Banque id_banque;
	
	@Column(name = "ADRESSE")
	@Embedded
	private Adresse adresse;

	
	public Client() {
		super();
	}
	
	public Client(String nom, String prenom, LocalDate dateNaissance, Banque id_banque,
			Adresse adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.id_banque = id_banque;
		this.adresse = adresse;
	}
	
	public void addCompte(Compte newCompte) {
		comptes.add(newCompte);
	}
	
}

