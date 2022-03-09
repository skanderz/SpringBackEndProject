package tn.spring.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.Entities.Appointement;


@Repository
public interface AppointementRepo extends CrudRepository <Appointement,Long> {
	@Query(value="SELECT * FROM APPOINTEMENT WHERE local LIKE ?1 ", nativeQuery = true)
	public List<Appointement> findByLocal(String local);

	
}
