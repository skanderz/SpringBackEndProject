package tn.spring.controllers;

import java.util.HashMap;   
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.entities.CourseDto;
import tn.spring.entities.Courses;
import tn.spring.repositories.CoursesRepository;
import tn.spring.services.CoursesService;






@RestController
@CrossOrigin
public class CoursesController {
	
	
	@Autowired
	private CoursesService coursesService ;
	
	
	private final CoursesRepository repository;
	
	CoursesController(CoursesRepository repository) {
	    this.repository = repository;
	    }

    
	
    
   
    
    
    @RequestMapping(value = "/affect", method = RequestMethod.POST)
   	public String affect(@RequestBody CourseDto course) throws Exception {
   		
    	 return  coursesService.affectation(course);
    	   
   	} 
     
    
   
 
    
}