package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Likee;
import tn.esprit.spring.repository.LikeeRepository;



@Service
public class LikeService implements ILikeService {
	@Autowired
	LikeeRepository likkerepository;
	
	@Override
	public Likee addlike(Likee l) 
	{
		
		return likkerepository.save(l);
	}

}
