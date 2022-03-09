package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Cagnotte;
@Repository
public interface Cagnotte_Repository extends JpaRepository<Cagnotte , Long > {

	
}
