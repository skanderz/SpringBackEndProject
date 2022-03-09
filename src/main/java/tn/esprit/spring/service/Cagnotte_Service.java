package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Cagnotte;
import tn.esprit.spring.repository.Cagnotte_Repository;
import tn.esprit.spring.repository.Event_Repository;
import tn.esprit.spring.repository.UserRepository;

@SuppressWarnings("ALL")
@Service
public class Cagnotte_Service implements Interface_Service_Cagnotte {

	  @Autowired
	   Cagnotte_Repository cagnotte_Repository;
	  @Autowired
	   UserRepository user_repository;
	  @Autowired
	    Event_Repository event_Repository; 
	
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
		cagnotte_Repository.deleteById(id);
	}

	@Override
	public void create(Cagnotte c) {
		// TODO Auto-generated method stub

		 cagnotte_Repository.save(c);
	}

	@Override
	public Cagnotte update(Cagnotte c, Long id) {
		// TODO Auto-generated method stub
		return cagnotte_Repository.save(c);
	}

	@Override
	public List<Cagnotte> getAll() {
		// TODO Auto-generated method stub
		return cagnotte_Repository.findAll();
	}

	@Override
	public Cagnotte getLast() {
		// TODO Auto-generated method stub
		Cagnotte c=new Cagnotte();
List<Cagnotte>  list =cagnotte_Repository.findAll();
for (Cagnotte cagnotte : list) {
	c=cagnotte;
}
		return c;
	}

}
