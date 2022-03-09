package tn.esprit.spring.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Complaint;
import tn.esprit.spring.entity.Status;
import tn.esprit.spring.entity.Statuss;
import tn.esprit.spring.entity.User;






@Repository
public interface ComplaintRepo  extends JpaRepository <Complaint,Long> ,CrudRepository <Complaint,Long>{
	List<Complaint> findByUser(User u );
	@Query("select count(c) from Complaint c where c.statuss=:statuss")
	int getComplaintByStatus(@Param("statuss") Statuss statuss);
}
