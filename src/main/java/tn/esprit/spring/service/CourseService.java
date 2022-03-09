package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Course;





public interface CourseService {
	List<Course>retrieveAllCourses();
	Course addCourse (Course c);
	void deleteCourse (Integer id);
	Course updateCourse (Course c);
	Optional<Course> retrieveCourse (Integer id);
	
	void listCourseParFormer(Integer idFormer);
	void affecterFormerACourse(Integer idCourse, Integer idFomer);
	
	


}
