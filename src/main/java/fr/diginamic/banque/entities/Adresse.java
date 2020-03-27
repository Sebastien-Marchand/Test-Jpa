package fr.diginamic.banque.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	private Integer numero;
	private String rue;
	private String ville;
	
	public Adresse() {
	}

	public Adresse(Integer numero, String rue, String ville) {
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
	}
	
}