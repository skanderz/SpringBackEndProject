package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Cagnotte;

@Repository
public interface CagnotteRep extends CrudRepository<Cagnotte, Integer> {

}
