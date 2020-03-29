package fr.diginamic.banque;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import fr.diginamic.banque.entities.Compte;
import fr.diginamic.banque.entities.Client;

@Entity
public class AssuranceVie extends Compte{

	LocalDate dateFin;
	double taux;
	
	public AssuranceVie() {
		super();
	}
	public AssuranceVie(List<Client> clients, LocalDate dateFin, Double taux) {
		super(clients);
		this.dateFin = dateFin;
		this.taux = taux;
	}
}
