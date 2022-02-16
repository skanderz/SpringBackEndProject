package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Qcm;

@Repository
public interface QcmRep extends CrudRepository<Qcm, Integer>{

}
