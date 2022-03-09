package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Space;
import tn.esprit.spring.repository.Space_Repository;

@SuppressWarnings("ALL")
@Service
public class Space_Service implements Interface_Space_Service {

	@Autowired
	Space_Repository space_Repository;
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		space_Repository.deleteById(id);
	}

	@Override
	public Space create(Space s) {		
		// TODO Auto-generated method stub
		s.setDisponibilte(true);
		return space_Repository.save(s);
	}

	@Override
	public Space update(Space s, Long id) {
		// TODO Auto-generated method stub
		return space_Repository.save(s);
	}

	@Override
	public List<Space> getAll() {
		// TODO Auto-generated method stub
		return space_Repository.findAll();
	}

	@Override
	public Space getSpaceById(Long id) {
		// TODO Auto-generated method stub
		return space_Repository.findById(id).get();
	}

}
