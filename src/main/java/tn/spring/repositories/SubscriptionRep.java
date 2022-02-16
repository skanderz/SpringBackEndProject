package tn.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.spring.entities.Subscription;


@Repository
public interface SubscriptionRep extends CrudRepository <Subscription,Integer>{

}
