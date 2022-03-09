package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Collection;

public interface Interface_Collection_Service {
	void delete(Long id);
	Collection create(Collection c);
	Collection update(Collection c );
	List<Collection> getAll();
	
	Collection getCollectionById(Long id);
}
