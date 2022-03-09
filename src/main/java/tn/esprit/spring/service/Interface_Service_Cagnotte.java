package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Cagnotte;

public interface Interface_Service_Cagnotte {
	void delete(Long id);
	void create(Cagnotte c);
	Cagnotte update(Cagnotte c ,Long id);
	List<Cagnotte> getAll();
	Cagnotte getLast();
	
}
