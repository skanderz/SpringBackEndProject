package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Subject;
import tn.esprit.spring.repository.SubjectRepository;
import tn.esprit.spring.service.ComplaintService;
import tn.esprit.spring.service.SubjectService;




@RestController
@RequestMapping("/subjects")
public class SubjecttController {

	@Autowired
	SubjectService subjectService;
	@Autowired
	ComplaintService compSer;
	@Autowired
	SubjectRepository subrepo;
	  @MessageMapping("/chat")
	

	
	
	@PostMapping("/addSubject")
	String addSubject(@RequestBody Subject s) {
		return subjectService.addSubject(s);
	}
	
	@PatchMapping("/Rating")
	void rating(@RequestBody Subject s,@RequestParam(name = "nbEtoiles")int nbEtoiles) {
		subjectService.Rating(s, nbEtoiles);
	}
	
	@DeleteMapping("/DeleteSujetRedondant")
	boolean checkAndDeletesujetRedondant(@RequestBody Subject s) {
		return subjectService.deleteSujetRedondant(s);
	}

	
}