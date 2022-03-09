package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Comments;
import tn.esprit.spring.entity.Post;
import tn.esprit.spring.repository.PostRepository;
import tn.esprit.spring.service.IPostService;

@RestController
public class PostController {
	@Autowired
	IPostService postService ;
	
	@Autowired
	PostRepository postRepository;
	
	@PostMapping("/add-post")
	@ResponseBody
	public void addPost(@RequestBody Post post )
	{
		  if ( post.getNbrVues() != 0 ) {  throw new ArithmeticException("Post Deleted !!!!");}	
	postService.ajouterPost(post);
	}
	
	
	@PutMapping("modify-post")
	@ResponseBody
	public void updatePost(@RequestBody Post post)
	{
		postService.modifierPost(post);
	}
	
	@DeleteMapping("/delete-post/{IdPub}")
	void deletePost(@PathVariable(name="IdPub") Integer IdPub)
	{
		postService.deletePost(IdPub);
	}
	
	@GetMapping("/retreive-all-posts")
	@ResponseBody
	public List<Post> getPost()
	{
		List<Post> listPosts= postService.retreiveAll();
		return listPosts;
	}
	
	@GetMapping("/retreive-post/{idPub}")
	@ResponseBody
	public Post getPostById(@PathVariable("idPub") Integer id)
	{
		Post p= postService.retrievePost(id);
		return p;
	}
   
	@GetMapping("/findByTopic/{topic}")
	@ResponseBody
	public List<Post> findByTopic(@PathVariable("topic") String topic)
	{
		List<Post> p= postRepository.findByTopic(topic);
		return p;
	}
	
	@GetMapping("/orderByDate")
	@ResponseBody
	public List<Post> orderByDate()
	{
		List<Post> p= postRepository.orderByDate();
		return p;
	}
	
	@GetMapping("/orderById")
	@ResponseBody
	public List<Post> orderById()
	{
		List<Post> p= postRepository.orderById();
		return p;
	}
}
