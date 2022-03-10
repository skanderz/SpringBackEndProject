package tn.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.DeliveryMen;

@Repository
public interface DeliveryMenRepository extends JpaRepository<DeliveryMen, Long> {

}
