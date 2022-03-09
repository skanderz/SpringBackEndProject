package tn.esprit.spring.controller;
import java.util.HashMap;  
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Formers;
import tn.esprit.spring.repository.FormersRepository;
import tn.esprit.spring.service.FormersService;





@RestController
@CrossOrigin
public class FormersController {
	
	
	@Autowired
	private FormersService formersService;
	
	
	private final FormersRepository repository;
	
	FormersController(FormersRepository repository) {
	    this.repository = repository;
	    }

    
	
    
   
    
    
    
   
     
     @RequestMapping(value = "/former/Get/{id}", method = RequestMethod.GET)
   	public Formers getFormer(@PathVariable long id) throws Exception {
     	 return formersService.getById(id);
  	}
     
     @RequestMapping(value = "/former/Delete/{id}", method = RequestMethod.DELETE)
   	public Map<String, String> deleteFormer(@PathVariable long id) throws Exception {
   		 HashMap<String, String> map = new HashMap<>();
   		 map.put("result", formersService.delete(id));
   		 return map;
   	}
    
}