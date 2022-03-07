package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.User;
 
@Repository
public interface User_Repository extends JpaRepository<User, Long> {

	
}
