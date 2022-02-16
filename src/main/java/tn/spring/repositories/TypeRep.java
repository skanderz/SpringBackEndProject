package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Type;
@Repository
public interface TypeRep extends CrudRepository<Type, Integer>{

}
