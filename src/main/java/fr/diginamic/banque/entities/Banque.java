package fr.diginamic.banque.entities;

import javax.persistence.*;


@Entity
@Table ( name = "BANQUE")
public class Banque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "NOM")
	String nom;
	
	public Banque() {
		
	}

	public Banque(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
	
	@Override
	public String toString() {
		return "Banque [nom=" + nom + "]";
	}
}
