package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.ERole;
import tn.esprit.spring.entity.User;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> ,CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByIduser(int iduser);
    List<User> findByStatus(boolean etat);
    Boolean existsByUsername(String id); 
    Optional<ERole> findByRole(ERole role);
    
    
    @Transactional
	@Modifying
	@Query("update User u set u.status=FALSE where u.iduser= :iduser")
	int DisableAccount(@Param("iduser") Long iduser);
    
    
    @Transactional
 	@Modifying
 	@Query("update User u set u.status=FALSE where u.iduser= :iduser")
 	int EnableAccount(@Param("iduser") Long iduser);
	
    
    @Transactional
 	@Modifying
 	@Query("update User u set u.password=:password where u.iduser= :iduser")
 	int ChangePassword(@Param("iduser") Long iduser ,@Param("password") String password);
    
    
    @Transactional
 	@Modifying
 	@Query("update User u set u.solde=:solde where u.iduser= :iduser")
 	int AddSolde(@Param("iduser") Long iduser ,@Param("solde") float solde);
    
    
    
    
    
    
    

	
    
    
}
