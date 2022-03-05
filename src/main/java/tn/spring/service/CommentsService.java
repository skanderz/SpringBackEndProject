package tn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import tn.spring.entities.Comments;
import tn.spring.repository.CommentsRepository;


@Service
public class CommentsService implements ICommentsService {

	
	@Autowired
	CommentsRepository commentsRepository;
	@Override
	public Comments ajouterComments(Comments comment) {
		return commentsRepository.save(comment);
		
	}
	@Override
	public Comments modifierComments(Comments comment) {
		return commentsRepository.save(comment);
	}
	@Override
	public void deleteComments(Integer IdCom) {
		commentsRepository.deleteById(IdCom);
		
	}
	@Override
	public List<Comments> retreveAllCommnts() {
		
		return (List<Comments>) commentsRepository.findAll();
	}
	
	
}
