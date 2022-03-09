package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.BadWords;


@Repository
public interface BadWordRepository extends CrudRepository<BadWords ,Long> ,JpaRepository<BadWords ,Long> {

}