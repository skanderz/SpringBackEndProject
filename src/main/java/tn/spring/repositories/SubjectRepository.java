package tn.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import tn.spring.entities.Subject;
@Repository
public interface SubjectRepository  extends JpaRepository<Subject, Long> {

}
