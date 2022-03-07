package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Avancement;
import tn.esprit.spring.entity.Offre;
import tn.esprit.spring.service.OffreService;
@RestController
@RequestMapping("offre")
public class OffreRestController {
	
	
	
	@Autowired
	OffreService offreService;
	
	
	@DeleteMapping("/delete/{id}")
	void delete(@PathVariable Long id) {
		offreService.delete(id);
	}
	@PostMapping("/create")
	Offre create(Offre o) {
		return offreService.create(o);
	}
	@PutMapping("/update/{id}")
	Offre update(Offre o ,@PathVariable Long id) {
		return offreService.update(o, id);
	}
	@GetMapping("getall")
	List<Offre> getAll(){
		return offreService.getAll();
	}
	@GetMapping("/getOffreById/{id}")
	Offre getOffreById(@PathVariable Long id) {
		return offreService.getOffreById(id);
	}
	@PutMapping("affecteroffrecondidat/{id_Offre}/{id_Condidat}")
	void affecter_Offre_Condidat(@PathVariable Long id_Offre,@PathVariable Long id_Condidat) {
		 offreService.affecter_Offre_Condidat(id_Offre, id_Condidat);
	}
	@GetMapping("/getAvancement/{id_Offre}/{id_Condidat}")
	Avancement getAvancement(@PathVariable Long id_Offre, @PathVariable Long id_Condidat) {
		return offreService.getAvancement(id_Offre, id_Condidat);
	}

	@PutMapping("/traiteoffre/{id_Offre}/{id_Condidat}")
	void traiter_Offre(@PathVariable Long id_Offre,@PathVariable Long id_Condidat,@RequestParam Avancement avancement) {
		offreService.traiter_Offre(id_Offre, id_Condidat, avancement);
	}
}
