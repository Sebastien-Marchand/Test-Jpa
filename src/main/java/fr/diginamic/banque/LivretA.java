package fr.diginamic.banque;

import java.util.List;

import javax.persistence.*;

import fr.diginamic.banque.entities.Compte;
import fr.diginamic.banque.entities.Client;

@Entity
public class LivretA extends Compte{

	double taux;

	public LivretA() {
		super();
	}

	public LivretA(double taux,List<Client> clients) {
		super(clients);
		this.taux = taux;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n\t- Taux : " + taux;
	}
}
