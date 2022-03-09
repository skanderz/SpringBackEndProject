package tn.esprit.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Courses;




public interface CoursesRepository extends CrudRepository<Courses, Long> ,JpaRepository<Courses, Long> {

	
	
	
	
}