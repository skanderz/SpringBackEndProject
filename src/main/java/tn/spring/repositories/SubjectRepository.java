package tn.spring.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import tn.spring.Entities.Subject;
@Repository
public interface SubjectRepository  extends JpaRepository<Subject, Long> {
	
	
	

}