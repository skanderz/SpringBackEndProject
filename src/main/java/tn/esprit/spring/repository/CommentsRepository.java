package tn.esprit.spring.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Comments;





@Repository
public interface CommentsRepository extends CrudRepository<Comments, Integer> {
	
	@Query(value="SELECT * FROM COMMENTS ORDER BY id_com", nativeQuery = true)
	public List<Comments> orderByIdComments();
	
	
		@Query(value="SELECT * FROM COMMENTS WHERE topic LIKE ?1 ", nativeQuery = true)
		public List<Comments> findByTopic(String topic);
		
		@Query(value="SELECT * FROM COMMENTS WHERE number LIKE ?1 ", nativeQuery = true)
		public List<Comments> findByNumber(Number number);
}
