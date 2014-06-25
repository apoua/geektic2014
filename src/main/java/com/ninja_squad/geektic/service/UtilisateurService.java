package com.ninja_squad.geektic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private UtilisateurDao dao;
	
	public UtilisateurService() {
	}

	@RequestMapping(value="/afficher/{id}", method = GET)
	public Utilisateur getUtlisateurById(@PathVariable("id") int id) {
		return dao.findById(id);
	}
	
	@RequestMapping(value="/lister", method = GET)
	public List<Utilisateur> getUtilisateurs() {
		return dao.findAll();
	}
	
	@RequestMapping(value="/rechercher/{sexe}/{listIdInterets}", method = GET)
	public List<Utilisateur> getUtilisateursCriteres(@PathVariable("sexe") String sexe, @PathVariable("listIdInterets") String listIdInterets) {
		String[] tabIdString = listIdInterets.split(",");
		List<Integer> listIdInt = new ArrayList<Integer>();
		for (String unId : tabIdString) {
			listIdInt.add(Integer.parseInt(unId));
		}
		return dao.findByCriteria(sexe, listIdInt);
	}
}
