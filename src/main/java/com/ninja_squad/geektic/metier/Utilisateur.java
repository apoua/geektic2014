package com.ninja_squad.geektic.metier;

import java.util.List;

import javax.persistence.*;

@Entity
public class Utilisateur {
	
	@Id
	private int id;
	
	private String nom;
	
	private String prenom;
	
	private String adresseMail;
	
	private String sexe;
	
	private String gravatar;
	
	@ManyToMany
	@JoinTable(name="UTIL_INTERET", joinColumns={@JoinColumn(name="ID_UTILISATEUR", referencedColumnName="ID")},
	      		 inverseJoinColumns={@JoinColumn(name="ID_INTERET", referencedColumnName="ID")})
	private List<CentreInterets> centreInterets;

	public List<CentreInterets> getCentreInterets() {
		return this.centreInterets;
	}

	public void setCentreInterets(List<CentreInterets> centreInterets) {
		this.centreInterets = centreInterets;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAddresseMail() {
		return adresseMail;
	}

	public void setAddresseMail(String addresseMail) {
		this.adresseMail = addresseMail;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getGravatar() {
		return gravatar;
	}

	public void setGravatar(String gravatar) {
		this.gravatar = gravatar;
	}
	
	
}
