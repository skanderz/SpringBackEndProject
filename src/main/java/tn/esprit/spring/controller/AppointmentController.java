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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Appointement;
import tn.esprit.spring.repository.AppointementRepo;
import tn.esprit.spring.service.IAppointmentService;


@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	@Autowired
	IAppointmentService appointmentService;
	@Autowired
	AppointementRepo apprepo;
	
	@PostMapping("/add-appointment")
	@ResponseBody 
	void addAppointment(@RequestBody Appointement app) {
		appointmentService.addAppointement(app);
	}
	 @GetMapping("/retrieve-allappointment")
	    @ResponseBody
	   List<Appointement> retrieveAllAppointments(){
		   return appointmentService.retrieveAllAppointements();
	   }
	    @PutMapping("/modify-appointment")
	    @ResponseBody
	    Appointement updateAppointment(@RequestBody Appointement app)
	    {
	    return appointmentService.updateAppointement(app);
	    }
	    @DeleteMapping("delete-appointment/{id}")
	    void deleteAppointment(@PathVariable(name="id")Long idApp){
	    	appointmentService.deleteAppointement(idApp);
	    }
	    @GetMapping("/findByLocal/{local}")
	    @ResponseBody
	    public List<Appointement> findByLocal(@PathVariable("local") String local)
	    {
	    List<Appointement> app= apprepo.findByLocal(local);
	    return app;
	    }
}
