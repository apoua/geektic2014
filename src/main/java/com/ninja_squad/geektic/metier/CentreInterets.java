package com.ninja_squad.geektic.metier;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "CENTRE_D_INTERETS")
public class CentreInterets {
	@Id
	private int id;
	
	private String libelle;

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	@ManyToMany(mappedBy="centreInterets")
	private List<Utilisateur> utilisateurs;
}
