package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Publicity;
@Repository
public interface PublicityRep extends CrudRepository<Publicity, Integer>{

}
