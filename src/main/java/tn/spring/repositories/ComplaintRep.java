package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Complaint;

@Repository
public interface ComplaintRep  extends CrudRepository <Complaint,Integer>{

}
