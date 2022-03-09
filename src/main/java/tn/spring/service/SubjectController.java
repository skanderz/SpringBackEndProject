package tn.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.services.*;
import tn.spring.services.SubjectService;

import tn.spring.entities.Subject;
import tn.spring.repositories.SubjectRepository;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

	@Autowired
	SubjectService subjectService;
	
	


	
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