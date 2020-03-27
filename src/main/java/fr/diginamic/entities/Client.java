package fr.diginamic.entities;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "CLIENT")

public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "NOM")
	String nom;
	
	@Column(name = "PRENOM")
	String prenom;
	
	@OneToMany(mappedBy="id_client")
	private Set<Emprunt> emprunts;
	
	public Client() {
	}

	public Client(int id, String nom, String prenom, Set<Emprunt> emprunts) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.emprunts = emprunts;
	}
	
	@Override
	public String toString() {
		return "Client [" + id + "], nom=" + nom + ", prenom=" + prenom ;
	}
}
