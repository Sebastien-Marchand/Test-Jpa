package fr.diginamic.banque.entities;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table ( name = "BANQUE")
public class Banque {
	
	@OneToMany(mappedBy="id_banque")
	private Set<Client> clients;
	
	@Column(name = "NOM")
	String nom;
	
	public Banque() {
		
	}

	public Banque(Set<Client> clients, String nom) {
		super();
		this.clients = clients;
		this.nom = nom;
	}
}
