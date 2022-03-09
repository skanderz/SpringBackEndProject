package tn.esprit.spring.service;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Course;
import tn.esprit.spring.entity.Former;
import tn.esprit.spring.repository.CourseRep;
import tn.esprit.spring.repository.FormerRep;


@Service
@Slf4j
public class CourseServiceImpl implements CourseService{
	@Autowired
	CourseRep courseRep;
	@Autowired
	FormerRep formerRep;
	
	@Override
	public List<Course> retrieveAllCourses() {
         log.info("Courses are Retrieved Successfully");
		
		return (List<Course>) courseRep.findAll();
		
	}
	
	

		
	
	@Override
	public Course addCourse(Course c) {
		log.info("The course is saved");
		return 		courseRep.save(c);
 
	}

	@Override
	public void deleteCourse(Integer id) {
		log.info("Deleting Course ");
		 courseRep.deleteById(id);
		
	}

	@Override
	public Course updateCourse(Course c) {
		log.info("Update Course");
        return courseRep.save(c);
	}

	@Override
	public Optional<Course> retrieveCourse(Integer id) {
		log.info("Course is Retrieved Successfully");
		return courseRep.findById(id) ;
	}

	


	
	@Override
	
	public void affecterFormerACourse(Integer idCourse, Integer idFormer) {
		int nb=0;
		Former f = formerRep.findById(idFormer).orElse(null);
		Course c =courseRep.findById(idCourse).orElse(null);
		f.getCourses().add(c);
		nb=nb+1;
		f.setNbrCourse(nb);
		 
		courseRep.save(c);	
		formerRep.save(f);
		
	}

	@Override
	public void listCourseParFormer(Integer idFormer) {
		int nb=0;
		Former f = formerRep.findById(idFormer).orElse(null);
		Set<Course> courses = f.getCourses();
		for (Course ff : courses){
		ff.getFormers();
		nb=nb+1;
		f.setNbrCourse(nb);
		
		
		
		
	}

	


	

	

	}}
