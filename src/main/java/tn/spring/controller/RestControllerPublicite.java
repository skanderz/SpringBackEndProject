package tn.esprit.spring.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.mail.MessagingException;

import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.AppConstants;
import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Publicite;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.Event_Repository;
import tn.esprit.spring.repository.User_Repository;
import tn.esprit.spring.requestApiForm.MessageResponse;
import tn.esprit.spring.service.IPubliciteService;
import tn.esprit.spring.service.Interface_Event_Service;

@RestController
@RequestMapping("/publicite")
public class RestControllerPublicite {
	@Autowired
	IPubliciteService ipubliciteService;
	@Autowired
	Interface_Event_Service event_Service;

	@Autowired
	Event_Repository event_Repository;
	@Autowired
	User_Repository repositoryUser;
	ObjectMapper objectMapper = new ObjectMapper();
	private Random rand = new Random();
	
	
	// http://localhost:8081/publicite/ajouter
	// {"nom":"Iphone","dateDebut":"2020-04-11","dateFin":"2020-05-11","nbrInitialVueCible":"100","nbrFinalVue":"500","cout":"30.500"}
	@PostMapping("/AddPub/{iduser}/{idevents}")
	public ResponseEntity<?> AddPub(@PathVariable(value = "iduser") Long iduser,@PathVariable(value = "idevents") Long idevents,@RequestParam(value = "Pub", required = true) String PubJson,@RequestParam(required = true, value = AppConstants.EMPLOYEE_FILE_PARAM) UploadedFile file) throws IOException,ParseException
	{
		User user=repositoryUser.findById(iduser).get();
		Publicite pub = objectMapper.readValue(PubJson, Publicite.class);
		Optional<Event> event = event_Service.getEventById(idevents);
		Publicite pp	=ipubliciteService.AddPub(pub, file);
        pp.setEmailProprietaire(user.getEmail());
        pp.setNumeroProprietaire(user.getTel());
		if (event.isPresent()) {
			Event ev = event.get();
			ev.setPublicite(pp);
			event_Repository.save(ev);

		}

		String dateDebut = pp.getDateDebut().toString();
		String dateFin = pp.getDateFin().toString();
		return ResponseEntity.ok(new MessageResponse("Successful"
				+ ipubliciteService.DifferenceJourDateDebutEtDateFin(dateDebut, dateFin) + "days" + "Publicite" + pp));
	}

	// http://localhost:8081/publicite/ajouter
	// {"nom":"Iphone","dateDebut":"2020-04-11","dateFin":"2020-05-11","nbrInitialVueCible":"100","nbrFinalVue":"500","cout":"30.500"}
	@PostMapping("/ajouter/{iduser}/{idevents}")
	public ResponseEntity<?> AjouterPub(@PathVariable(value = "iduser") Long iduser,@PathVariable(value = "idevents") Long idevents,
			@RequestParam(value = "Pub", required = true) String PubJson,
			@RequestParam(required = true, value = AppConstants.EMPLOYEE_FILE_PARAM) MultipartFile file)
			throws JsonParseException, JsonMappingException, IOException, ParseException {
	
		Publicite p = objectMapper.readValue(PubJson, Publicite.class);
		Optional<Event> event = event_Service.getEventById(idevents);
	
		Publicite pp = ipubliciteService.Add(PubJson, file,iduser);
	      
		if (event.isPresent()) {
			Event ev = event.get();
			ev.setPublicite(pp);
			event_Repository.save(ev);

		}

		String dateDebut = p.getDateDebut().toString();
		String dateFin = p.getDateFin().toString();
		return ResponseEntity.ok(new MessageResponse("Successful"
				+ ipubliciteService.DifferenceJourDateDebutEtDateFin(dateDebut, dateFin) + "days" + "Publicite" + pp.toString()));

	}

	// http://localhost:8081/publicite/afficher
	@GetMapping("/recherche/{nomRecherchePub}")
	public List<Publicite> RecherchePublicite(@PathVariable(value = "nomRecherchePub") String nomRecherchePub) {
		if (nomRecherchePub==null){
		return ipubliciteService.findAll();
		}

		else {
			return ipubliciteService.findLikeName(nomRecherchePub);
		}
	}

	// http://localhost:8081/publicite/delete/3
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> DeletePublicite(@PathVariable(value = "id") Long idPub) {
		ipubliciteService.Delete(idPub);
		return ResponseEntity.ok("Supprimé avec succès");
	}

	// http://localhost:8081/publicite/edit/2
	// {"nom":"Iphone","dateDebut":"2020-04-11","dateFin":"2020-05-11","nbrInitialVueCible":"100","nbrFinalVue":"500","cout":"30.500"}
	@PutMapping("/edit/{id}")
	public ResponseEntity<Publicite> EditPublicite(@PathVariable(value = "id") Long idPub, @RequestBody Publicite p) {
		Publicite PubUpdated = ipubliciteService.Update(p, idPub);
		return ResponseEntity.ok().body(PubUpdated);

	}

	@PutMapping("/PublicityFinished")
	public void PublicityFinished() throws MessagingException {
		ipubliciteService.PublicityFinished();
	}
	@GetMapping("/getPubForAll")
	public Publicite getPubForAll(){
		List<Publicite> listpub=ipubliciteService.findPubForAll();
		Publicite publicite=null;
		if(listpub.isEmpty()){
			return null;
		}
		else {
		int random=rand.nextInt(listpub.size());
		Publicite pub=listpub.get(random);
		listpub.remove(random);
		if(!listpub.isEmpty()){
		publicite=listpub.get(rand.nextInt(listpub.size()));
		return publicite;
		}
		return pub;
			 }
	}
	@GetMapping("/getPubForUserConnecter/{idUserConnecter}")
	public Publicite getPubForUserConnecter(@PathVariable(value = "idUserConnecter") Long idUserConnecter){
		User user=repositoryUser.findById(idUserConnecter).get();
		List<Publicite> listpub=ipubliciteService.getPubForUserConnecter(user.getDateN(), user.getSexe().toString());

		int random=rand.nextInt(listpub.size());
		Publicite pub=listpub.get(random);
		listpub.remove(random);
	
		return pub;
		}
	@PutMapping("/incrementNrbVuePublicite/{idpub}")
	public void incrementNrbVuePublicite(@PathVariable Long idpub){
		
		ipubliciteService.incrementNrbVuePublicite(idpub);
	
	}
	
	
}
