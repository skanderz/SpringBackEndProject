package tn.esprit.spring.service;

import java.util.List;



import tn.esprit.spring.entity.Comments;

public interface ICommentsService {
	
	public Comments ajouterComments(Comments comment);
	public Comments modifierComments(Comments comment);
	public void deleteComments(Integer IdCom);
	public List<Comments> retreveAllCommnts();
	//public void	ajouterEtaffecterListeComment(Comments comment, Integer IdPub);



}
