package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Likee;





@Repository

public interface LikeeRepository extends CrudRepository<Likee , Long>  {

}

