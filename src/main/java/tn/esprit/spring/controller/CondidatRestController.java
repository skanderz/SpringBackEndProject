package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Condidat;
import tn.esprit.spring.entity.Offre;
import tn.esprit.spring.service.CondidatService;

@RestController
@RequestMapping("condidat")
public class CondidatRestController {
   @Autowired
   CondidatService service;
	 @DeleteMapping("/delete/{idCondidat}")
	void delete(@PathVariable  Long idCondidat) {
		 service.delete(idCondidat);
	}
	 @PostMapping("/create")
	Condidat create(@RequestBody Condidat c) {
		return service.create(c);
	}
	 @PutMapping("/update/{idCondidat}")
	Condidat update(@RequestBody Condidat c ,@PathVariable Long idCondidat) {
		return service.update(c, idCondidat);

	}
	 @GetMapping("/getall")
	List<Condidat> getAll(){
		return service.getAll();

	}
	 @GetMapping("/getCondidatById/{idCondidat}")

	Condidat getCondidatById(@PathVariable Long idCondidat) {
		return service.getCondidatById(idCondidat);

	}
	
}
