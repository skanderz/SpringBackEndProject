package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Certificat;

@Repository
public interface CertificatRep  extends CrudRepository<Certificat, Integer> {


}
