package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Space;
@Repository
public interface Space_Repository extends JpaRepository<Space , Long > {

}
