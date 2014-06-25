package com.ninja_squad.geektic.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.metier.CentreInterets;

@Repository
public class CentreInteretsDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public CentreInteretsDao() 
	{
	}

	public List<CentreInterets> findAll()	{
		Query query = entityManager.createQuery("SELECT distinct(ci) FROM CentreInterets as ci", CentreInterets.class);
		return query.getResultList();
	}
}