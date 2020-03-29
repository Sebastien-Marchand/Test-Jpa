package fr.diginamic.banque.entities;

import java.util.ArrayList;
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
		this.operations = new ArrayList<>();
	}
	public void addOperation(Operation newOperation) {
		operations.add(newOperation);
	}
	
	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append(this.getClass().getSimpleName()).append(" ").append("\n\t- propriétaire(s) : ");
		clients.stream().map(c -> c.getId()).forEach(i -> builder.append("client ").append(i).append(", "));
		builder.append("\n\t - Operations : ");
		operations.stream().forEach(o -> builder.append(o));

		return builder.toString();
	}

	public Object getId() {
		return id;
	}

}
