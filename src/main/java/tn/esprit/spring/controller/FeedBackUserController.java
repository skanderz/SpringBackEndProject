package tn.esprit.spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.service.IFeedBackUserService;


@RestController
public class FeedBackUserController {
	@Autowired 
	IFeedBackUserService feedbackUserService;
	@GetMapping(value ="/note/{iduser}")
	@ResponseBody
	public float SommeNoteparuser(@PathVariable("iduser") Long iduser) 
	{
			
	return feedbackUserService.SommeNote(iduser);
		    
	}

}
