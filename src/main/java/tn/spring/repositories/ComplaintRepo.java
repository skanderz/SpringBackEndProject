package tn.spring.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.spring.Entities.Complaint;
import tn.spring.Entities.Status;
import tn.spring.Entities.User;




@Repository
public interface ComplaintRepo  extends JpaRepository <Complaint,Long>{
	List<Complaint> findByUser(User u );
	@Query("select count(c) from Complaint c where c.status=:status")
	int getComplaintByStatus(@Param("status") Status status);
}
