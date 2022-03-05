package tn.spring.service;

import java.util.List;



import tn.spring.entities.Comments;

public interface ICommentsService {
	
	public Comments ajouterComments(Comments comment);
	public Comments modifierComments(Comments comment);
	public void deleteComments(Integer IdCom);
	public List<Comments> retreveAllCommnts();



}
