package com.ninja_squad.geektic.dao;

import javax.persistence.EntityManager;

import com.ninja_squad.geektic.metier.Utilisateur;

public class UtilisateurDao {
	
	private EntityManager entityManager;
	
	public UtilisateurDao(EntityManager em) 
	{
		this.entityManager = em;
	}
	
	public Utilisateur findById(int id) {
		return entityManager.find(Utilisateur.class, id); 
	}
	
}
