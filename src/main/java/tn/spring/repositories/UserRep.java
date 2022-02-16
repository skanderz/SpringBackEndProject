package tn.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import tn.spring.entities.User;

@Repository
public interface UserRep extends JpaRepository <User,Integer>{

}
