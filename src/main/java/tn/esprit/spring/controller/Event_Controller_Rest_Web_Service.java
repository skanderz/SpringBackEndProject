package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.esprit.spring.entity.Cagnotte;
import tn.esprit.spring.entity.Event;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.requestApiForm.MessageResponse;
import tn.esprit.spring.service.Interface_Event_Service;
@Api(tags = "Gestion des Evenment")
@SuppressWarnings({"UnnecessaryLocalVariable", "SpringJavaAutowiredFieldsWarningInspection"})
@RestController
@RequestMapping("/event")
public class Event_Controller_Rest_Web_Service {
    @Autowired
    private Interface_Event_Service eventService;
 
    @Autowired
    private UserRepository user_repository;
  

    @PostMapping("/Create-Event")
    public ResponseEntity<?> CreateEvent(@RequestBody Event eventRequest) {
     
        Event eventToSave = new Event();
        eventToSave.setStart_date(eventRequest.getStart_date());
        eventToSave.setEnd_date(eventRequest.getEnd_date());
        eventToSave.setName(eventRequest.getName());
        eventToSave.setDescription(eventRequest.getDescription());
   

        return    eventService.create_Event(eventToSave); // Persist the event ;


    }


    @RequestMapping("/Participe-event/{id_event}/{user_id}")
    public ResponseEntity<?> Participe(@PathVariable("id_event") Long id_event,  @PathVariable("user_id") Long user_id) {
  
            return eventService.paticipe(id_event, user_id);
       
    }

    @GetMapping(value = "Get-All-Event")
    public List<Event> getAllEvent() {
        List<Event> list = eventService.getAll();
        return list;
    }

    @GetMapping(value = "/days_remaining/{id_event}")
    public ResponseEntity<?> get_number_of_days_remaining_of_this_event(@PathVariable("id_event") Long id_event) {
        Event thisEvent = eventService.getEventById(id_event).orElseThrow(() -> new RuntimeException("Not found"));
        Date endDate = thisEvent.getEnd_date();
        Date startDate = thisEvent.getStart_date();

        int numberOfDay = thisEvent.getNumberOFdaybythisEvent();
        Date now = new Date();
        long Check_diff = now.getTime() - endDate.getTime();
       
        long restofdays=startDate.getTime() - now.getTime();
        long dif = TimeUnit.DAYS.convert(Check_diff, TimeUnit.MILLISECONDS);
        long res = TimeUnit.DAYS.convert(restofdays, TimeUnit.MILLISECONDS);

        if (dif > 0) {
            return ResponseEntity.ok(new MessageResponse("This Event is already finished"));
        }
        return ResponseEntity.ok(new MessageResponse(" numberOfDay " + numberOfDay +"  restofdays "+ Math.abs(restofdays)));
    }

    @DeleteMapping("/delete_event/{id_event}")
    public ResponseEntity<?> delete_Event_by_identify(@PathVariable("id_event") Long id_event) {
      return  eventService.delete_Event(id_event);
    }

    @GetMapping("/get_event_by_id/{id_event}")
    public Optional<Event> get_event_by_id(@PathVariable("id_event") Long id_event){
       return  eventService.getEventById(id_event);
    }
    @PostMapping("/affecter_cagnotte/{idEvent}/{idPart}")
    ResponseEntity<?>  affecter_Ajouter_Cagnotte_Event(@RequestBody Cagnotte cag,@PathVariable Long idEvent,@PathVariable Long idPart)
    {
    	return	eventService.affecter_Ajouter_Cagnotte_Event(cag,idEvent, idPart);
    }
    @PutMapping("/affecter_space/{idSpace}/{idEvent}")
    ResponseEntity<?> affecter_Ajouter_Space_Event(@PathVariable Long idSpace,@PathVariable Long idEvent)
    {
    	return	eventService.affecter_Space_Event(idSpace, idEvent);
    }
    @PutMapping("/affecter_collection/{idCollection}/{idEvent}")
    ResponseEntity<?> affecter_Ajouter_Collection_Event(@PathVariable Long idCollection,@PathVariable Long idEvent) {
    	return	eventService.affecter_Ajouter_Collection_Event(idCollection, idEvent);
    }
    @PutMapping("/stat")
    ResponseEntity<?> Stat() {
    	return	eventService.Statistique();
    }
}