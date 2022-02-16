package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Post;
@Repository
public interface PostRep extends CrudRepository<Post, Integer> {

}
