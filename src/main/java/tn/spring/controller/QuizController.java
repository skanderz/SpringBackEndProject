package tn.spring.controllers;

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

import tn.spring.ApiR.APIResponse;
import tn.spring.entities.Qcm;

import tn.spring.services.QuizService;

@RestController

public class QuizController {
	@Autowired
	QuizService qcmService;
	//récuperer auto un bean de spring
	//traiter les reponses si on a pas besoin de exploiter le code sous forme http
	@PostMapping("/add-quiz")
	@ResponseBody
	Qcm addQcm(@RequestBody Qcm q){
		return qcmService.addQcm(q);
	} 
	@GetMapping
    private APIResponse<List<Qcm>> getQcms() {
        List<Qcm> allQcms = qcmService.retrieveAllQcm();
        return new APIResponse<>(allQcms.size(), allQcms);
    }
	@GetMapping("/{field}")
    private APIResponse<List<Qcm>> getQcmssWithSort(@PathVariable String field) {
        List<Qcm> allQcms = qcmService.findQcmswithSorting(field);
        return new APIResponse<>(allQcms.size(), allQcms);
    }


	
	@PutMapping("/modify-qcm")
	@ResponseBody
	Qcm updateQcm(@RequestBody Qcm q){
		return qcmService.updateQcm(q);
	}
	
	@DeleteMapping("delete-qcm/{id}")
	void deleteQcm(@PathVariable(name="id")Integer idQcm){
		qcmService.deleteQcm(idQcm); 
	
	}
	
	
	@GetMapping("/pagination/{offset}/{pageSize}")
    private APIResponse<Page<Qcm>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Qcm> qcmsWithPagination = qcmService.findQcmsWithPagination(offset, pageSize);
        return new APIResponse<>(qcmsWithPagination.getSize(), qcmsWithPagination);
    }
	
	
	@GetMapping("/QcmbyId/{idQcm}") 
	 @ResponseBody 
	 Qcm QcmById(@PathVariable(name="idQcm")Integer idQcm){
		 return  qcmService.retrieveQcm(idQcm).orElse(null);
}
	}