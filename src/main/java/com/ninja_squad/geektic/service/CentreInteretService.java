package com.ninja_squad.geektic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ninja_squad.geektic.dao.CentreInteretsDao;
import com.ninja_squad.geektic.metier.CentreInterets;

@RestController
@Transactional
@RequestMapping("/centre_interets")
public class CentreInteretService {
	
	@Autowired
	private CentreInteretsDao ciDao;

	public CentreInteretService() {
	}
	
	@RequestMapping(value="/lister", method = RequestMethod.GET)
	public List<CentreInterets> getCentreInterets() {
		return ciDao.findAll();
	}
}
