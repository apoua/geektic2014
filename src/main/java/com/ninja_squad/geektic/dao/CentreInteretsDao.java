package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.*;

import com.ninja_squad.geektic.metier.Utilisateur;

public class CentreInteretsDao {
	
	private EntityManager entityManager;
	
	public CentreInteretsDao(EntityManager em) 
	{
		this.entityManager = em;
	}
}
