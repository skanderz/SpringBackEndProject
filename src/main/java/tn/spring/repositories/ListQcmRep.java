package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.ListQcm;

@Repository
public interface ListQcmRep extends CrudRepository<ListQcm, Integer>{

}
