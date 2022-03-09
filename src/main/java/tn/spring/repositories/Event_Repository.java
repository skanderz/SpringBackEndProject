package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Sexe;

@Repository
public interface Event_Repository extends JpaRepository<Event , Long > {
	


    @Transactional
    @Modifying
    @Query("delete from Event e where e.hasFinished =true ")
    void delete_Event_Has_Finished();

    @Query("select e from Event e where e.hasFinished =true ")
    Event getHasFinished();
    
   //Statistique Seleon Sexe
	//@Query("select  count(E) from Event A join E.participant p  where  p.id=:id")
//int  countallparticipant(@Param("id") Long id);
	//@Query("select  count(E) from Event A join E.participant p  where  p.sex LIKE CONCAT('%',:sexe,'%')" )
	//int  countsexe(@Param("sexe") Sexe sexe);
	
    
}
