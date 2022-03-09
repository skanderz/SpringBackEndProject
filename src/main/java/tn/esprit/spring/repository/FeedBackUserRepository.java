package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.FeedBackUser;


@Repository
public interface FeedBackUserRepository extends CrudRepository<FeedBackUser, Long>,JpaRepository<FeedBackUser, Long> {
	@Query("SELECT SUM(f.note) FROM FeedBackUser f where (f.userr.iduser =:iduser)")  
    public float SommeNote(@Param ("iduser") Long iduser);

}
