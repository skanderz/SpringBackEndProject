package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Appointement;


@Repository
public interface AppointementRep  extends CrudRepository <Appointement,Integer>{

}
