package tn.spring.service;

import java.util.List;


import tn.spring.entities.Post;

public interface IPostService {

	public Post ajouterPost(Post post);
	public Post modifierPost(Post post);
	public void deletePost(Integer IdPub);
	public List<Post> retreiveAll();
	public Post retrievePost(Integer idPub);
	
}
