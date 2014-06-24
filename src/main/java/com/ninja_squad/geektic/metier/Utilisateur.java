package com.ninja_squad.geektic.metier;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sequenceGen")
	@SequenceGenerator(name="sequenceGen", sequenceName="utilisateur_seq")
	private int id;
	
	private String nom;
	
	private String prenom;
	
	private String addresseMail;
	
	private String sexe;
	
	private String gravatar;
	
	
}
