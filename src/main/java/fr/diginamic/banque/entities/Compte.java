package fr.diginamic.banque.entities;

import java.util.List;

import javax.persistence.*;


@Entity
@Table ( name = "COMPTE")
public class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany(mappedBy="comptes")
	private List<Client> clients;
	
	@Column(name = "OPERATIONS")
	@OneToMany( mappedBy = "compte")
	private List<Operation> operations;

	public Compte() {
		super();
	}
	
	public Compte( List<Client> clients) {
		this.clients = clients;
	}
	public void addOperation(Operation newOperation) {
		operations.add(newOperation);
	}

}
