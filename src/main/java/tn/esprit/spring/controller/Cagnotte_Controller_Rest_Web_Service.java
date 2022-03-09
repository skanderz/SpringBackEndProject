package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Cagnotte;
import tn.esprit.spring.service.Interface_Service_Cagnotte;

@SuppressWarnings({"UnnecessaryLocalVariable", "SpringJavaAutowiredFieldsWarningInspection"})
@RestController
@RequestMapping("/cagnotte")
public class Cagnotte_Controller_Rest_Web_Service {
	   @Autowired
	    private Interface_Service_Cagnotte service_Cagnotte;
	   @DeleteMapping("/delete/{}id")
	   void delete(@PathVariable Long id)
	   {
		   service_Cagnotte.delete(id); 
	   }
	
	   @PutMapping("/update/{id}")
	   Cagnotte update(@RequestBody Cagnotte c ,@PathVariable Long id)
		{
			return service_Cagnotte.update(c, id);
		}
	    @GetMapping("/getall")
		List<Cagnotte> getAll(){
			
		return	service_Cagnotte.getAll();
		}
}
