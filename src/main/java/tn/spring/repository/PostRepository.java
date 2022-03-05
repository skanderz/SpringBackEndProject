package tn.spring.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer>{

	@Query(value="SELECT * FROM POST ORDER BY id_pub", nativeQuery = true)
	public List<Post> orderById();
	
	
	@Query(value="SELECT * FROM POST ORDER BY date_pub", nativeQuery = true)
	public List<Post> orderByDate();
	
	//filtre
	@Query(value="SELECT * FROM POST WHERE topic LIKE ?1 ", nativeQuery = true)
	public List<Post> findByTopic(String topic);
}
