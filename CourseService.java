package tn.spring.services;

import java.util.List;
import java.util.Optional;

import tn.spring.entities.Course;
import tn.spring.entities.Former;



public interface CourseService {
	List<Course>retrieveAllCourses();
	Course addCourse (Course c);
	void deleteCourse (Integer id);
	Course updateCourse (Course c);
	Optional<Course> retrieveCourse (Integer id);
	
	void listCourseParFormer(Integer idFormer);
	void affecterFormerACourse(Integer idCourse, Integer idFomer);
	
	


}
