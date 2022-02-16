package tn.spring.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Response;

@Repository
public interface ResponseRep extends CrudRepository<Response, Integer>{

}
