package tn.spring.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Course;


@Repository
public interface CourseRep extends CrudRepository<Course, Integer>{
	Optional<Course> findById(Integer idCourse);
}
