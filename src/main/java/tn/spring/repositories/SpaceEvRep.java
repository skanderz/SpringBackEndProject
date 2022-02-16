package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.SpaceEv;
@Repository
public interface SpaceEvRep extends CrudRepository<SpaceEv, Integer>{

}
