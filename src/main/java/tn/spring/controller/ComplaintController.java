package tn.spring.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.BadWordFilter;
import tn.spring.Api.APIResponse;
import tn.spring.Entities.Complaint;
import tn.spring.Services.IComplaintService;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {
	@Autowired
	IComplaintService complaintService;
	
	//@PostMapping("/add-complaint")
	//@ResponseBody 
	//void addComplaint(@RequestBody Complaint complaint) {
	//	complaintService.addComplaint(complaint);
	//}
	 @GetMapping("/retrieve-allComplaint")
	    @ResponseBody
	   List<Complaint> retrieveAllComplaints(){
		   return complaintService.retrieveAllComplaints();
	   }
	    @PutMapping("/modify-complaint")
	    @ResponseBody
	    Complaint updateComplaint(@RequestBody Complaint c)
	    {
	    return complaintService.updateComplaint(c);
	    }
	    @DeleteMapping("delete-complaint/{id}")
	    void deleteComplaint(@PathVariable(name="id")Long idComplaint){
	    	complaintService.deleteComplaint(idComplaint);
	    }
	    //liste de reclamation d'un user
	    
	
		@GetMapping("/liste-complaint/{idUser}")
		@ResponseBody
		 List<Complaint> listeComplaints(@PathVariable("idUser") Long idUser){
			return complaintService.listeComplaints(idUser);
	
}
		@GetMapping("/retrieve-id/{idComplaints}")
		@ResponseBody
		Optional<Complaint> retrieveComplaints(@PathVariable(name="idComplaints")Long idComplaints){
		return complaintService.retrieveComplaints(idComplaints);
		}
		 @GetMapping
		    private APIResponse<List<Complaint>> getComplaints() {
		        List<Complaint> allComplaints = complaintService.retrieveAllComplaints();
		        return new APIResponse<>(allComplaints.size(), allComplaints);
		    }

	    @GetMapping("/{field}")
	    private APIResponse<List<Complaint>> getComplaintsWithSort(@PathVariable String field) {
	        List<Complaint> allComplaints = complaintService.findComplaintWithSorting(field);
	        return new APIResponse<>(allComplaints.size(), allComplaints);
	    }
	    @GetMapping("/pagination/{offset}/{pageSize}")
	    private APIResponse<Page<Complaint>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
	        Page<Complaint> complaintsWithPagination = complaintService.findComplaintsWithPagination(offset, pageSize);
	        return new APIResponse<>(complaintsWithPagination.getSize(), complaintsWithPagination);
	    }
	    @PostMapping("/add-complaint")
		public void addComplaints(@RequestBody Complaint complaint){
	    	complaint.setDescription( BadWordFilter.getCensoredText(complaint.getDescription()));
	    	complaintService.addComplaint(complaint);
		}
	   }
