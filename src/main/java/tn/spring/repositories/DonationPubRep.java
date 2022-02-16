package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.DonationPub;
@Repository
public interface DonationPubRep extends CrudRepository<DonationPub, Integer>{

}
