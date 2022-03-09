package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.ListQcm;


@Repository
public interface ListQcmRep extends CrudRepository<ListQcm, Integer> ,JpaRepository<ListQcm, Integer>{

}
