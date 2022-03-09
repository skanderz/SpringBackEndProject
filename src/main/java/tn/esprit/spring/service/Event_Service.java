package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Cagnotte;
import tn.esprit.spring.entity.Collection;
import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Sexe;
import tn.esprit.spring.entity.Space;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.Event_Repository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.requestApiForm.MessageResponse;

@SuppressWarnings("ALL")
@Service
public class Event_Service implements Interface_Event_Service {
	@Autowired
	private Event_Repository event_repository;
	@Autowired
	private UserRepository  user_repository;
	@Autowired
	Interface_Collection_Service collection_Service;
	@Autowired
	Interface_Service_Cagnotte service_Cagnotte;
	@Autowired
	Interface_Space_Service space_Service;

	@Override
	public ResponseEntity<?> create_Event(Event event) {

		event_repository.save(event);
		return ResponseEntity.ok(new MessageResponse("Event " + event.getName() + " has been registered  "));
	}

	@Override
	public ResponseEntity<?> delete_Event(Long id_event) {
		event_repository.deleteById(id_event);
		return ResponseEntity.ok(new MessageResponse("Event  has been deleted "));
	}

	@Override
	public Optional<Event> getEventById(Long id_Event) {
		return event_repository.findById(id_Event);
	}

	@Override
	public ResponseEntity<?> paticipe(Long event_id, Long id_user) {
		Event this_event = event_repository.findById(event_id).orElse(null);
		User Participant = user_repository.findById(id_user).orElse(null);
		Event existingEvent = event_repository.findById(event_id)
				.orElseThrow(() -> new RuntimeException("Event not found "));

		if (existingEvent.getSpace().getCapacity() == 0) {
			existingEvent.getSpace().setDisponibilte(false);
			return ResponseEntity.badRequest().body(new MessageResponse("no place available in this event"));
		}
		if (this_event.getParticipant().contains(Participant)) {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Participant " + Participant.getFirstname() + " already exist"));
		} else {

			this_event.getSpace().setCapacity(this_event.getSpace().getCapacity() - 1);

			this_event.getParticipant().add(Participant);

			event_repository.save(this_event);
			return ResponseEntity.ok(new MessageResponse("Participant " + Participant.getFirstname()
					+ " has been registered to event " + existingEvent.getName()));
		}

	}

	@Override
	public ResponseEntity<?> update_Event(Event event, Long id) {
		// TODO Auto-generated method stub
		Event Event_To_update = event_repository.findById(id).orElse(null);
		Event_To_update.setName(event.getName());
		Event_To_update.setDescription(event.getDescription());
		Event_To_update.setCollection(event.getCollection());
		Event_To_update.setEnd_date(event.getEnd_date());
		Event_To_update.setStart_date(event.getStart_date());
		Event_To_update.setSpace(event.getSpace());
		Event_To_update.setCagnotte(event.getCagnotte());
		return ResponseEntity.ok(new MessageResponse("Event " + event.getName() + " has been updated "));

	}

	@Override
	public List<Event> getAll() {
		// TODO Auto-generated method stub
		return event_repository.findAll();
	}

	@Override
	public ResponseEntity<?> affecter_Ajouter_Cagnotte_Event(Cagnotte cag, Long idEvent, Long idPart) {
		// TODO Auto-generated method stub
		Event Event_To_Affecter = event_repository.findById(idEvent).get();
		User Participant = user_repository.findById(idPart).orElse(null);
		Collection col = Event_To_Affecter.getCollection();

		col.setCharity(col.getCharity() + cag.getAmount());
		collection_Service.update(col);

		cag.setId_Event(Event_To_Affecter);
		// cag.getId_Part().add(Participant);
		// user_repository.save(Participant);
		service_Cagnotte.create(cag);
		Participant.getCagnotte().add(cag);

		Cagnotte c = service_Cagnotte.getLast();
		Event_To_Affecter.setCagnotte(c);
		event_repository.save(Event_To_Affecter);
		return ResponseEntity.ok(new MessageResponse(
				"cagnotte " + c.getAmount() + " has been registered to event " + Event_To_Affecter.getName()));

	}

	@Override
	public ResponseEntity<?> affecter_Space_Event(Long idSpace, Long idEvent) {
		// TODO Auto-generated method stub
		Event Event_To_Affecter = event_repository.findById(idEvent).orElse(null);
		Space s = space_Service.getSpaceById(idSpace);
		if (s.isDisponibilte()) {
			Event_To_Affecter.setSpace(s);
			event_repository.save(Event_To_Affecter);
			return ResponseEntity.ok(new MessageResponse(
					"Space" + s.getLocal() + " has been affected to event " + Event_To_Affecter.getName()));

		} else {
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Space " + s.isDisponibilte() + " is not disponible"));

		}

	}

	@Override
	public ResponseEntity<?> affecter_Ajouter_Collection_Event(Long idCollection, Long idEvent) {

		// TODO Auto-generated method stub

		Event Event_To_Affecter = event_repository.findById(idEvent).orElse(null);
		Collection c = collection_Service.getCollectionById(idCollection);
		Event_To_Affecter.setCollection(c);
		event_repository.save(Event_To_Affecter);
		return ResponseEntity.ok(new MessageResponse(
				"Collection " + c.getCharity() + " has been registered to event " + Event_To_Affecter.getName()));

	}
	@Override 

	public ResponseEntity<?> Statistique() {
		// TODO Auto-generated method stub

		String response = "";

		List<User> users = user_repository.findAll();

		float allparticipants=0;
		for (User part : users) {
			allparticipants=event_repository.countallparticipant(part.getIduser())+allparticipants;
		}
		
	
			float count_femme = (event_repository.countsexe(Sexe.FEMME)
					/ allparticipants) * 100;
			float count_home = (event_repository.countsexe(Sexe.HOMME)
					/ allparticipants) * 100;
	

			response =  "nombre total participant" +allparticipants
					   +"  les nombres femme  sont "+ count_femme +"  % "
			+" les nombres  Homme  sont " + count_home + " %";
		    
	
		return ResponseEntity.ok(new MessageResponse(response));

	}

}
