package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Qcm;


@Repository
public interface QcmRep extends JpaRepository<Qcm, Integer> ,CrudRepository<Qcm, Integer>{

}
