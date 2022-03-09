package tn.spring.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.spring.entities.FeedBackUser;


@Repository
public interface FeedBackUserRepository extends CrudRepository<FeedBackUser, Long> {
	@Query("SELECT SUM(f.note) FROM FeedBackUser f where (f.user.userId =:userId)")  
    public float SommeNote(@Param ("userId") Long userId);

}
