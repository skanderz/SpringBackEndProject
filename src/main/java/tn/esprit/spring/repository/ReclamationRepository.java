package tn.esprit.spring.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Reclamation;


@Repository
public interface ReclamationRepository extends JpaRepository <Reclamation, Long> {
	
	///raed
	@Query(value = "SELECT r.etat, r.date_rec,COUNT(r.id) AS NBB FROM reclamation r WHERE CAST(r.date_rec AS DATE)=DATE(NOW( ))-?1 GROUP BY r.etat LIMIT 6", nativeQuery = true)
	public List<Object[]> ReclamtionPerDayEtat(Integer date);
	   @Query("select  r from Reclamation r where r.condidat.id=:id")
	    public List<Reclamation> findMyReclams(@Param("id")long id);

	    @Query("select r from Reclamation r where r.dateRec>=:start and r.dateRec<=:end")
	    public List<Reclamation> findBetweenDate(@Param("start")LocalDateTime start,@Param("end") LocalDateTime end);


	    @Query("select r from Reclamation r where lower(r.titre) like lower(concat('%', :filter,'%'))")
	    public List<Reclamation> findByFilter(@Param("filter") String filter);


}
