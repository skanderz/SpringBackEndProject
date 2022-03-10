package tn.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer>{
	@Query(
			  value = "SELECT * FROM delivery  WHERE deliver_men_id=?1 and state=1", 
			  nativeQuery = true)
	public List<Delivery> allDelivriesByDeliveryMen(Long id);

}
