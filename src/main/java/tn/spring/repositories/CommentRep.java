package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Comments;
@Repository
public interface CommentRep extends CrudRepository<Comments, Integer>{

}
