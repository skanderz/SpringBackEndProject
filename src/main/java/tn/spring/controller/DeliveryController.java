package tn.spring.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.repositories.DeliveryMenRepository;
import tn.spring.services.DeliveryMenService;
import tn.spring.services.DeliveryService;
import tn.spring.entities.Delivery;
import tn.spring.entities.DeliveryMen;

@RestController
@RequestMapping("/Delivery")
public class DeliveryController {

	//récuperer auto un bean de spring

	@Autowired
	DeliveryService ds;
	@Autowired
	DeliveryMenService dm;
	
	//	//traiter les reponses si on a pas besoin de exploiter le code sous forme http
	@RequestMapping(value="/newDelivery",method=RequestMethod.POST)
	@ResponseBody Delivery newDelivery (@RequestBody Delivery d,@RequestParam(name="id",defaultValue="0")Long DeliveryMenId) {		
		return ds.addDelivery(d, DeliveryMenId);
		
	}
	
	@PatchMapping("/updateDelivery")
	 Delivery updateDelivery (@RequestBody Delivery d,@RequestParam(name="id",defaultValue="0")Long DeliveryMenId) {		
		return ds.updateDelivery(d, DeliveryMenId);
		
	}
	
	@GetMapping("/delivriesByDM/{id}")
	List<Delivery> getDeliveriesByDeliveryMen(@PathVariable("id") Long id){
		return ds.allDelivriesByDeliveryMen(id);
	}
	
	@GetMapping("/distance")
	Map<Long,Double> getDistance(){
		return dm.plusProcheDeliveryMen();
	}
	
	@GetMapping("/stats")
	HashMap<Long, Integer> getDeliveryMenOfTheMonth(){
		return dm.stats();
	}
	
	@GetMapping("/prime")
	void prime(){
		 dm.attributePrimeToDeliveryMen();
	}
	
	
}
