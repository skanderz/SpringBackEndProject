package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Space;

public interface Interface_Space_Service {
	
	void delete(Long id);
	Space create(Space s);
	Space update(Space s ,Long id);
	List<Space> getAll();
	Space getSpaceById(Long id);
	
	

}
