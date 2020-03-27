package fr.diginamic.banque.entities;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table ( name = "BANQUE")
public class Banque {
	
	@Column(name = "NOM")
	String nom;
	
	public Banque() {
		
	}

	public Banque(String nom) {
		this.nom = nom;
	}
}
