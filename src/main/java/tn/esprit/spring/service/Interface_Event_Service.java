package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import tn.esprit.spring.entity.Cagnotte;
import tn.esprit.spring.entity.Event;

public interface Interface_Event_Service {
	ResponseEntity<?>  create_Event(Event event);

    ResponseEntity<?>  delete_Event(Long id);

    Optional<Event> getEventById(Long id);
    ResponseEntity<?>  update_Event(Event event, Long id);

    ResponseEntity<?>  paticipe(Long event_id, Long id_user);
    
    List<Event> getAll();
    ResponseEntity<?>  affecter_Ajouter_Cagnotte_Event(Cagnotte c,Long idEvent, Long idPart);
    ResponseEntity<?>  affecter_Space_Event(Long idSpace,Long idEvent);
    ResponseEntity<?>  affecter_Ajouter_Collection_Event(Long idCollection ,Long idEvent);
    public ResponseEntity<?> Statistique() ;

}
