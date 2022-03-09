package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.service.SubscriptionService;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.SubscriptionRepository;
import tn.esprit.spring.entity.Subscription;
import tn.esprit.spring.service.UserService;
import tn.esprit.spring.service.SubscriptionService;



@RestController
@RequestMapping("/Subscription")
public class SubscriptionController {




@Autowired   SubscriptionService SubscriptionService;
@Autowired	 SubscriptionRepository SubscriptionRepo;


// http://localhost:8075/SpringMVC/Subscription/retrieve-all-Subscriptions
@GetMapping("/retrieve-all-Subscriptions")
@ResponseBody
public List<Subscription> getSubscriptions() {  List<Subscription> listSubscriptions = SubscriptionService.retrieveAllSubscription();
                                                return listSubscriptions;  } 



// http://localhost:8075/SpringMVC/Subscription/retrieve-Subscription/8
@GetMapping("/retrieve-Subscription/{Subscription-id}")
@ResponseBody
public Subscription retrieveSubscription(@PathVariable("Subscription-id") Long SubscriptionId) { 
return SubscriptionService.retrieveSubscription(SubscriptionId);   }




// http://localhost:8075/SpringMVC/Subscription/add-Subscription
@PostMapping("/add-Subscription")
@ResponseBody
public Subscription addSubscription(@RequestBody Subscription c) { 	return SubscriptionService.addSubscription(c); }



// http://localhost:8075/SpringMVC/Subscription/remove-Subscription/{Subscription-id}
@DeleteMapping("/remove-Subscription/{Subscription-id}")
@ResponseBody
public void removeSubscription(@PathVariable("Subscription-id") Long SubscriptionId) { SubscriptionService.deleteSubscription(SubscriptionId); }



@PutMapping("/ChangeToPremium/{idSub}")
@ResponseBody
public int ChangeToPremium(@PathVariable Long idSub ) {	 return SubscriptionService.ChangeToPremium(idSub);	}


@PutMapping("/ChangeToBasic/{idSub}")
@ResponseBody
public int ChangeToBasic(@PathVariable Long idSub ) {	 return SubscriptionService.ChangeToBasic(idSub);	}



//http://localhost:8089/SpringMVC/client/modify-client
@PutMapping("/ExtendSubscription/{idSub}/{dateFin}")
@ResponseBody
public int ExtendSubscription(@PathVariable Long idSub ,@PathVariable(name = "dateFin")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateFin) {
return SubscriptionService.ExtendSubscription(idSub,dateFin);		}
		
		

	
}






