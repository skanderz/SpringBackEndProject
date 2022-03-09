package tn.esprit.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Formers;



public interface FormersRepository extends CrudRepository<Formers, Long> ,JpaRepository<Formers, Long> {

	
	
	
	
}