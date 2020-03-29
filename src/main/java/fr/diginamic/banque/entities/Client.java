package fr.diginamic.banque.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "ID"))
	private List<Compte> comptes;
	
	
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
		this.comptes = new ArrayList<>();
	}
	
	public void addCompte(Compte newCompte) {
		this.comptes.add(newCompte);
		}

	public Object getId() {
		return id;
	}
	
	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("Client ").append(id).append(" ").append(nom).append(" ").append(prenom)
				.append(" \n\t- Banque : ").append(id_banque.getNom()).append("\n\t- Compte(s) : ");

		comptes.stream().map(c -> c.getId()).forEach(i -> builder.append(i).append(", "));
		return builder.toString();
	}
	
}

