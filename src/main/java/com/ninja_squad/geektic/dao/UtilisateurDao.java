package com.ninja_squad.geektic.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.persistence.criteria.*;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.metier.CentreInterets;
import com.ninja_squad.geektic.metier.Utilisateur;

@Repository
public class UtilisateurDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public UtilisateurDao() 
	{
	}
	
	public Utilisateur findById(int id) {
		Utilisateur util = entityManager.find(Utilisateur.class, id); 
		Hibernate.initialize(util.getCentreInterets());
		return util;
	}
	
	public List<Utilisateur> findAll() {
		Query query = entityManager.createQuery("SELECT distinct(u) FROM Utilisateur as u LEFT JOIN FETCH u.centreInterets", Utilisateur.class);
	    return query.getResultList();
	}
	
	public List<Utilisateur> findByCriteria(String sexe, List<Integer> listIdInterets) {
		Query query = entityManager.createQuery("SELECT distinct(u) FROM Utilisateur as u LEFT JOIN FETCH u.centreInterets ci WHERE u.sexe =:sexe AND ci.id IN :listIdInterets", Utilisateur.class);
		query.setParameter("sexe", sexe);
		query.setParameter("listIdInterets", listIdInterets);
		return query.getResultList();
	}
	
	public List<Utilisateur> findByInterests(List<CentreInterets> interests) {
		String jpql = "select distinct geek from Geek geek join geek.interests as i where i in (:interests)";
		return entityManager.createQuery(jpql, Utilisateur.class).setParameter("interests", interests).getResultList();
	}
}
