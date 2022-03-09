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

import tn.esprit.spring.entity.Collection;
import tn.esprit.spring.service.Interface_Collection_Service;

@SuppressWarnings({"UnnecessaryLocalVariable", "SpringJavaAutowiredFieldsWarningInspection"})
@RestController
@RequestMapping("/collection")

public class Collection__Controller_Rest_Web_Service {
	   @Autowired
	    private Interface_Collection_Service collection_Service;
	   
	   @DeleteMapping("/delete/{}id")
	   void delete(@PathVariable Long id)
	   {
		   collection_Service.delete(id); 
	   }
	   @PostMapping("/create")
	   Collection create(@RequestBody Collection c)
		{
			return collection_Service.create(c);
		}
	   @PutMapping("/update")
	   Collection update(@RequestBody Collection c)
		{
			return collection_Service.update(c);
		}
	    @GetMapping("/getall")
		List<Collection> getAll(){
			
		return	collection_Service.getAll();
		}
	   
	   
	   
	   
}
