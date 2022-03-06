package tn.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Publicity;
import tn.spring.entities.Type;

@Repository
public interface PublicityRepository extends JpaRepository<Publicity, Integer> {
	@Query("select count(c) from Publicity c where c.type=:type")
	int getPublicityByType(@Param("type") Type type);
	
	
	@Query(value="Select MAX(nbr_final_vues) from Publicity",nativeQuery = true)
	 public Integer NbreMax();
}
