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

import tn.esprit.spring.entity.Space;
import tn.esprit.spring.service.Interface_Space_Service;

@SuppressWarnings({"UnnecessaryLocalVariable", "SpringJavaAutowiredFieldsWarningInspection"})
@RestController
@RequestMapping("/space")

public class Space_Controller_Rest_Web_Service {
	
	
	   @Autowired
	    private Interface_Space_Service space_Service;

	   @DeleteMapping("/delete/{}id")
	   void delete(@PathVariable Long id)
	   {
		   space_Service.delete(id); 
	   }
	   @PostMapping("/create")
		Space create(@RequestBody Space s)
		{
			return space_Service.create(s);
		}
	   @PutMapping("/update/{id}")
		Space update(@RequestBody Space s ,@PathVariable Long id)
		{
			return space_Service.update(s, id);
		}
	    @GetMapping("/getall")
		List<Space> getAll(){
			
		return	space_Service.getAll();
		}
	   
}
