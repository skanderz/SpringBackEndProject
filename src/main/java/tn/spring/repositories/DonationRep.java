package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Donation;
@Repository
public interface DonationRep extends CrudRepository<Donation, Integer>{

}
