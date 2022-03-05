package tn.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.BadWordFilter;
import tn.spring.entities.Comments;
import tn.spring.entities.Post;
import tn.spring.repository.CommentsRepository;
import tn.spring.service.ICommentsService;

@RestController
public class CommentsController {
	@Autowired
	ICommentsService commentService;
	@Autowired
	CommentsRepository commentRepository;
	//@PostMapping("/add-comment")
	//@ResponseBody
	//public void addComments(@RequestBody Comments comment)
	//{
		//commentService.ajouterComments(comment);
//	}
	
	@PostMapping("/add-comment")
	public void addComments(@RequestBody Comments comment){
		comment.setTopic( BadWordFilter.getCensoredText(comment.getTopic() ));
	       commentService.ajouterComments(comment);
	}
	
	
	
	
	@PutMapping("modify-comments")
	@ResponseBody
	public void updateComments(@RequestBody Comments comment)
	{
		commentService.modifierComments(comment);
	}
	
	
	@DeleteMapping("/delete-comments/{IdCom}")
	void deletePost(@PathVariable(name="IdCom") Integer IdCom)
	{
		commentService.deleteComments(IdCom);
	}
	
	@GetMapping("/retreive-all-comments")
	@ResponseBody
	public List<Comments> getComments()
	{
		List<Comments> listComments= commentService.retreveAllCommnts();
		return listComments;
	}
	@GetMapping("/orderByIdC")
	@ResponseBody
	public List<Comments> orderByIdComments()
	{
		List<Comments> c=commentRepository.orderByIdComments();
		return c;
	}
	@GetMapping("/findByTopicComm/{topic}")
	@ResponseBody
	public List<Comments> findByTopic(@PathVariable("topic") String topic)
	{
		List<Comments> c= commentRepository.findByTopic(topic);
		return c;
	}
	
	
	@GetMapping("/findByNumber/{number}")
	@ResponseBody
	public List<Comments> findByBumber(@PathVariable("number") Number number)
	{
		List<Comments> c= commentRepository.findByNumber(number);
		return c;
	}
	
	
	
	
}
