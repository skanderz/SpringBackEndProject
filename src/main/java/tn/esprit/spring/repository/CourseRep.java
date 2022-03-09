package tn.esprit.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Course;



@Repository
public interface CourseRep extends CrudRepository<Course, Integer> ,JpaRepository<Course, Integer>{
	Optional<Course> findById(Integer idCourse);
}
