package fr.diginamic.banque.entities;

import java.time.LocalDate;

import javax.persistence.*;


@Entity
@Table ( name = "COMPTE")
public class Operation {
	
	@Column(name = "DATE")
	LocalDate date;
	
	@Column(name = "MONTANT")
	double montant;
	
	@Column(name = "MOTIF")
	String motif;

	@Column(name = "ID_COMPTE")
	@ManyToOne
	@JoinColumn ( name = "OPERATION")
	private Banque id_compte;
}
