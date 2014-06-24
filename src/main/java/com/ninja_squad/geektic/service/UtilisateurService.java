package com.ninja_squad.geektic.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.config.AppConfig;
import com.ninja_squad.geektic.dao.UtilisateurDao;
import com.ninja_squad.geektic.metier.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@Transactional
@RequestMapping("/utilisateur")
public class UtilisateurService {
	
	private EntityManager em;
	private UtilisateurDao dao;
	private static EntityManagerFactory emFactory;
	
	public UtilisateurService() {
		emFactory = Persistence.createEntityManagerFactory("GEEKTIC");
		em = emFactory.createEntityManager();
		dao = new UtilisateurDao(em);
	}

	@RequestMapping(value="/{id}", method = GET)
	public Utilisateur getUtlisateurById(@PathVariable("id") int id) {
		return dao.findById(id);
	}
	
	@RequestMapping(value="/list", method = GET)
	public List<Utilisateur> getUtilisateurs() {
		return dao.findAll();
	}
	
	//@RequestMapping(value="/list", method = POST)
	//public List<Utilisateur> getUtilisateursByCriteres(@RequestParam(required = false) String sexe, @RequestParam(required = false) List<String> interets) {
	//	return dao.findAll();
	//}
}
