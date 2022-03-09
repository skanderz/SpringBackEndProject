package tn.spring.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.Entities.BadWord;

@Repository
public interface BadWordRepository extends CrudRepository<BadWord ,Long> {

}