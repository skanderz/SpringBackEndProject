package tn.esprit.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Subscription;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.repository.SubscriptionRepository;
@Slf4j
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	
@Autowired	SubscriptionRepository SubscriptionRepo;

	
@Override	public List<Subscription> retrieveAllSubscription() {	return (List<Subscription>) this.SubscriptionRepo.findAll();}
@Override	public Subscription addSubscription(Subscription c) {	return this.SubscriptionRepo.save(c);	}
@Override	public void deleteSubscription(Long id)             {	this.SubscriptionRepo.deleteById(id);	}
@Override	public Subscription retrieveSubscription(Long id)   {	return this.SubscriptionRepo.findById(id).orElse(null);	}
	


@Override   public  int ExtendSubscription(Long idSub,Date dateFin) { return  SubscriptionRepo.ExtendSubscription(idSub ,dateFin);}
@Override   public  int ChangeToPremium(Long idSub) { return SubscriptionRepo.ChangeToPremium(idSub);   }
@Override   public  int ChangeToBasic(Long idSub) { return SubscriptionRepo.ChangeToBasic(idSub);   }



}




