package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Api.APIResponse;
import tn.esprit.spring.entity.Publicity;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.PublicityRepository;
import tn.esprit.spring.service.IPublicityService;

@RestController
public class PublicityController {

	@Autowired
	IPublicityService publicityService;
	@Autowired
	PublicityRepository pubRepository;
	@PostMapping("/add-pub")
	@ResponseBody
	public void addPublicity(@RequestBody Publicity pub)
	{
		publicityService.ajouterPublicity(pub);
	}
	@PutMapping("modify-publicity")
	@ResponseBody
	public void updatePublicity(@RequestBody Publicity pub)
	{
		publicityService.modifierPublicity(pub);
	}
	@DeleteMapping("/delete-pub/{IdPub}")
	void deletePublicity(@PathVariable(name="IdPub") Integer IdPub)
	{
		publicityService.deletePublicity(IdPub);
	}
	
	@GetMapping("/retreive-all-pub")
	@ResponseBody
	public List<Publicity> getPublicity()
	{
		List<Publicity> listPublicity= publicityService.retreiveAllPub();
		return listPublicity;
	}
	@GetMapping("/pagination/{offset}/{pageSize}")
	   private APIResponse<Page<Publicity>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
	       Page<Publicity> publicitysWithPagination = publicityService.findComplaintsWithPagination(offset, pageSize);
	       return new APIResponse<>(publicitysWithPagination.getSize(), publicitysWithPagination);
	   }
	
	
	
	@GetMapping("/nbre-max-pub")
	@ResponseBody
	public  Publicity NbreMax()
	{
		List<Publicity> PubList = publicityService.retreiveAllPub();
		Integer pmax= pubRepository.NbreMax();  int test = 0;  int getId = 0;
		for (Publicity p : PubList) { if(p.getNbrFinalVues() == pmax)  {  test=1; getId = p.getIdPub(); }}
		
		return publicityService.retrievePublicity(getId);
		
	}
	

	}
