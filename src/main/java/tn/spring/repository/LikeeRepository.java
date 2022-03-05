package tn.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Likee;



@Repository

public interface LikeeRepository extends CrudRepository<Likee , Long>  {

}

