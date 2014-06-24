package com.ninja_squad.geektic.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	private static EntityManagerFactory emFactory;
	
	public UtilisateurService() {
		emFactory = Persistence.createEntityManagerFactory("GEEKTIC");
	}

	@RequestMapping(value="/id={id}", method = GET)
	public Utilisateur getUtlisateurById(@PathVariable("name") int id) {
		em = emFactory.createEntityManager();
		UtilisateurDao dao = new UtilisateurDao(em);
		return dao.findById(id);
	}
	
	@RequestMapping(value="/list", method = GET)
	public String getTwo() {
		return "Salut ";
	}
}
