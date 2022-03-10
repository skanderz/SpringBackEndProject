package tn.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;


import tn.spring.services.IFeedBackUserService;

@RestController
public class FeedBackUserController {
	private final static String SID_ACCOUNT = "ACdbed50f907d3950b6b6dbe9b73dad002";
	private final static String AUTH_ID = "597417453e56cf57eb2cb037d9afa51f";
	private final static String FROM_NUMBER="+16367914781";
	private final static String TO_NUMBER =" +21620693939";

	
	//récuperer auto un bean de spring
	//traiter les reponses si on a pas besoin de exploiter le code sous forme http

	@Autowired 
	IFeedBackUserService feedbackUserService;
	@GetMapping(value ="/note/{userId}")
	@ResponseBody
	public float SommeNoteparuser(@PathVariable("userId") Long userId) 
	{ 
		Call.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER),
				new com.twilio.type.Twiml("<Response><Say>you have passed the exam and you will recieve your certificate immediately by Mail </Say></Response>"))
				        .create();
	return feedbackUserService.SommeNote(userId);
		    
	}
	static {
		Twilio.init(SID_ACCOUNT, AUTH_ID);
		}
	
	
	


}
