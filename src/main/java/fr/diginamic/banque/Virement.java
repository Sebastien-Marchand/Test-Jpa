package fr.diginamic.banque;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import fr.diginamic.banque.entities.Compte;
import fr.diginamic.banque.entities.Operation;

@Entity
@DiscriminatorValue("virement")
public class Virement extends Operation{

	private String beneficiaire;
	
	public Virement() {
		super();
	}
	public Virement(LocalDate date, Double montant, String modif, Compte compte, String beneficiaire) {
		super(date, montant, modif, compte);
		this.beneficiaire = beneficiaire;
	}
}
