package fr.diginamic.banque.entities;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table ( name = "COMPTE")
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany(mappedBy="livres")
	private Set<Client> clients;
	
	@Column(name = "OPERATION")
	@OneToMany( mappedBy = "id_compte")
	private Operation operation;

}
