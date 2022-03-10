package tn.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.entities.FormerDto;
import tn.spring.entities.Formers;
import tn.spring.repositories.FormersRepository;

                                     

@Service
public class FormersService  {
	@Autowired
	private FormersRepository formerDao;


	public Formers save(FormerDto former) {
		Formers newFormer =  new Formers();
		newFormer.setNomprenom(former.getNomprenom());
		newFormer.setSpecialite(former.getSpecialite());
		newFormer.setEmail(former.getEmail());
		return formerDao.save(newFormer);
	}
	
	public String update(FormerDto former) {
		
		Formers newFormer = formerDao.findById(former.getId()).get();
		newFormer.setNomprenom(former.getNomprenom());
		newFormer.setSpecialite(former.getSpecialite());
		newFormer.setEmail(former.getEmail());
	
		return "done";
	}
	
	public Formers getById(long id) {
		Formers former = formerDao.findById(id).get();
		return former;
	}
		
	
	public String delete(long id) {
		Formers former  = formerDao.findById(id).get();
		formerDao.delete(former);
		return "done";
	}
	
	
	
	
}