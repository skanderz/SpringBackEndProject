package tn.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.entities.Post;
import tn.spring.repository.PostRepository;
@Service
public class PostService  implements IPostService{
	
	
	@Autowired
	PostRepository postRepository;

	@Override
	public Post ajouterPost(Post post){
		return postRepository.save(post);
	}

	@Override
	public Post modifierPost(Post post) {
		return postRepository.save(post);
	}

	@Override
	public void deletePost(Integer IdPub) {
		postRepository.deleteById(IdPub);
		
	}

	@Override
	public List<Post> retreiveAll() {
		 return (List<Post>) postRepository.findAll();
	}

	@Override
	public Post retrievePost(Integer idPub) {
		Post p= postRepository.findById(idPub).get();
		return p;
	}

	



	
	

	

	

	
	
	

	
}
