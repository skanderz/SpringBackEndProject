package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Collection;
import tn.esprit.spring.repository.Collection_Repository;

@SuppressWarnings("ALL")
@Service
public class Collection_Service implements Interface_Collection_Service {

	@Autowired
	Collection_Repository collection_Repository;
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		collection_Repository.deleteById(id);
	}

	@Override
	public Collection create(Collection c) {
		// TODO Auto-generated method stub
		return collection_Repository.save(c);
	}

	@Override
	public Collection update(Collection c) {
		// TODO Auto-generated method stub
		return collection_Repository.save(c);
	}

	@Override
	public List<Collection> getAll() {
		// TODO Auto-generated method stub
		return collection_Repository.findAll();
	}

	@Override
	public Collection getCollectionById(Long id) {
		// TODO Auto-generated method stub
		return collection_Repository.findById(id).orElse(null);
	}

}
