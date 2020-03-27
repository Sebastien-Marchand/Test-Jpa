package fr.diginamic.banque.entities;

import java.time.LocalDate;

import javax.persistence.*;


@Entity
@Table ( name = "COMPTE")
public class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "DATE")
	LocalDate date;
	
	@Column(name = "MONTANT")
	double montant;
	
	@Column(name = "MODIF")
	String modif;

	@ManyToOne
	@JoinColumn ( name = "id_compte")
	private Compte compte;

	public Operation() {
		super();
	}

	public Operation(LocalDate date, double montant, String modif, Compte compte) {
		super();
		this.date = date;
		this.montant = montant;
		this.modif = modif;
		this.compte = compte;
	}
}
