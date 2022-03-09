package tn.spring.controllers;

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

import tn.spring.ApiR.BadWordFilter;
import tn.spring.entities.Course;
import tn.spring.entities.Qcm;
import tn.spring.services.CourseService;


@RestController
public class CourseController {

	@Autowired
	CourseService courseService;
	
	
	@PostMapping("/add-course")
	public void addComments(@RequestBody Course course){
		course.setDescription( BadWordFilter.getCensoredText(course.getDescription() ));
		courseService.addCourse(course);
	}
	@GetMapping("/retrieve-allCourse")
	@ResponseBody
	List<Course> retrieveAllCourses(){
		return courseService.retrieveAllCourses();
	}
	@PutMapping("/modify-course")
	@ResponseBody
	Course updateCourse(@RequestBody Course c){
		return courseService.updateCourse(c);
	}
	
	@DeleteMapping("delete-course/{id}")
	void deleteCourse(@PathVariable(name="id")Integer idCourse){
		courseService.deleteCourse(idCourse); 
	
	}
	
	
	@PostMapping("/add-Course/{idCourse}/former/{idFormer}")
	@ResponseBody 
	void AffFormer(@PathVariable Integer idCourse, @PathVariable Integer idFormer){
		courseService.affecterFormerACourse(idCourse, idFormer);
	}
	
	@GetMapping("/CoursebyId/{idCourse}") 
	 @ResponseBody 
	 Course CourseById(@PathVariable(name="idCourse")Integer idCourse){
		 return  courseService.retrieveCourse(idCourse).orElse(null);
}
	}