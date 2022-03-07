package tn.esprit.spring.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.requestApiForm.MessageResponse;
import tn.esprit.spring.service.OffreService;
import tn.esprit.spring.service.ReclamationService;

@RestController
@RequestMapping("/reclamation")
public class ReclamationController {

	@Autowired
	ReclamationService reclamationService;

	@Autowired
	OffreService offreService;


	/* Enregistrer une Reclamation */

	@PostMapping("/create/{userid}/{idoffre}")
	public  ResponseEntity<?> create(@RequestBody Reclamation rec, @PathVariable Long userid, @PathVariable Long idoffre) {
		String [] wordsFromText = rec.getDescription().split(" ");
		
		 if (reclamationService.badWordsValidation(wordsFromText))
		 {
	            return ResponseEntity.ok(reclamationService.create(rec, userid, idoffre));

		 
		
			
		}
		 else
		 {
	            return ResponseEntity.badRequest().body(new MessageResponse("klem 5ayeb"));
 
		 }
	}

	/* get all Reclamation */
	@GetMapping("/affichall")
	public List<Reclamation> getAllrec() {

		return reclamationService.findall();

	}

	@PutMapping("/modifier/{idreq}")

	public Reclamation updaterec(@RequestBody Reclamation rec, @PathVariable Long idreq) {
		return reclamationService.update(rec, idreq);
	}

	@DeleteMapping("/delete/{id}")

	public void delete(@PathVariable Long id) {
		reclamationService.delete(id);
	}
	@PutMapping("/traiter/{idreq}")
	void  traiter(@PathVariable Long idreq,@RequestParam(value = "Rep", required = true) String  reponse)
	{
		reclamationService.traiter(idreq, reponse);
	}
	@GetMapping("/reclamtionPerDayEtat")

	public List<Object[]> ReclamtionPerDayEtat(@RequestParam Integer date)
	{
		return reclamationService.ReclamtionPerDayEtat(date);
	}
	@GetMapping("/findOnebyid/{rec_id}")
	public Reclamation findbyid(@PathVariable Long rec_id) {
		return reclamationService.findbyid(rec_id);
	}


    @GetMapping("/myReclam/{id}")
    public ResponseEntity<?> MyReclam(@PathVariable int id){
        List<Reclamation> reclams=reclamationService.findMyReclam(id);
        return  new ResponseEntity<>(reclams,HttpStatus.OK);
    }
    @GetMapping("/filter")
    public ResponseEntity<?> FilterReclam(@RequestBody String filter){

        return new ResponseEntity<>(reclamationService.filter(filter),HttpStatus.OK);

    }
    @GetMapping("/between")
    public ResponseEntity<?> findBetweenDate(@RequestParam String start,@RequestParam String end){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime s = LocalDateTime.parse(start, formatter);
        LocalDateTime e = LocalDateTime.parse(end, formatter);


        return new ResponseEntity<>(reclamationService.findBetweenDate(s,e),HttpStatus.OK);
    }
    @GetMapping("/searchmulti")
    public ResponseEntity<?> searchMulti(HttpServletRequest request){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        String filter="";
        String type="";
        boolean mine=false;
        LocalDateTime start=LocalDateTime.parse("2013-12-31 00:00",formatter);
        LocalDateTime end=LocalDateTime.parse("2030-12-31 00:00",formatter);;
        boolean treated=false;
        int id=0;
        if(request.getParameter("filter")!=null){
            filter=request.getParameter("filter");

        }
      if(request.getParameter("mine")!=null && request.getParameter("id")!=null){
            mine=Boolean.parseBoolean(request.getParameter("mine"));
            id=Integer.parseInt(request.getParameter("id"));

        }
        if(request.getParameter("start")!=null){
            start = LocalDateTime.parse(request.getParameter("start"), formatter);



        }
        if(request.getParameter("end")!=null){
            end = LocalDateTime.parse(request.getParameter("end"), formatter);
        }

        if(request.getParameter("treated")!=null){
            treated=Boolean.parseBoolean(request.getParameter("treated"));

        }

        return new ResponseEntity<> (reclamationService.searchMultiCriteria(filter,type,mine,start,end,treated,id),HttpStatus.OK);


    }

}
