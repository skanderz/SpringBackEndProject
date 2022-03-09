package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Offre;
@Repository
public interface OffreRepository extends JpaRepository<Offre , Long > {

}
