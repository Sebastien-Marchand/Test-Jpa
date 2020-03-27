package fr.diginamic.banque;

import fr.diginamic.banque.entities.Compte;

public class LivretA extends Compte{

	double taux;

	public LivretA() {
		super();
	}

	public LivretA(double taux) {
		super();
		this.taux = taux;
	}
}
