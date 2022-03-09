package tn.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.services.IFeedBackUserService;

@RestController
public class FeedBackUserController {
	@Autowired 
	IFeedBackUserService feedbackUserService;
	@GetMapping(value ="/note/{userId}")
	@ResponseBody
	public float SommeNoteparuser(@PathVariable("userId") Long userId) 
	{
			
	return feedbackUserService.SommeNote(userId);
		    
	}

}
