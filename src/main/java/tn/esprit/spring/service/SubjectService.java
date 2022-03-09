package tn.esprit.spring.service;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Subject;
import tn.esprit.spring.repository.SubjectRepository;



@Service
public class SubjectService   {
	@Autowired
	SubjectRepository subjectRepository;
	
	public String addSubject(Subject s) {
		if(this.sujetRedondant(s)) {
			return "Error!!! redundant subject!";
		}else {
			subjectRepository.save(s);
			return "Subject added successfully";
		}
	}
	
	public boolean deleteSujetRedondant(Subject s ) {
		if(this.sujetRedondant(s)) {
			subjectRepository.delete(s);
			return true;
		}
		return false;
	}
	
	public boolean sujetRedondant(Subject s) {
		Predicate<Subject> p1 = x -> x.getSubjectName().equals(s.getSubjectName());
		 boolean b = subjectRepository.findAll().stream().anyMatch(p1)  ? true : false;
		return b;
	}
	
	@Scheduled(cron = "0 0 0 * * 6", zone = "Europe/Paris")
	public void DeleteSujetSansInteraction() {
		subjectRepository.findAll().stream().forEach(x->{
			if(x.getCommentings().size()<3) {
				System.out.println("Sujet sans interaction  "+x.toString());
				subjectRepository.delete(x);
			}
		});
		
	}
	
	
	
	public void Rating (Subject s, int nbEtoiles) {
		s.setEvaluate((s.getEvaluate()+nbEtoiles)/2);
		subjectRepository.save(s);
	}

	
	public List<Subject> retrieveAllSubjects() {
		
		return (List<Subject>) subjectRepository.findAll();
	}
	


}
