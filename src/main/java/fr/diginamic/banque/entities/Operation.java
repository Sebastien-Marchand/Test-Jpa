package fr.diginamic.banque.entities;

import java.time.LocalDate;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
@DiscriminatorValue("OP")
@Table ( name = "operation")
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
	
	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append("\n\t").append(this.getClass().getSimpleName()).append(" du ").append(date.toString())
				.append("\n\t- Montant : ").append(montant).append("€").append("\n\t- Modification : ").append(modif);

		return builder.toString();
	}
}
