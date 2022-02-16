package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Space;

@Repository
public interface SpaceRep extends CrudRepository<Space, Integer>{

}
