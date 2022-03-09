package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Avancement;
import tn.esprit.spring.entity.Offre;

public interface OffreService {
	void delete(Long id);
	Offre create(Offre o);
	Offre update(Offre o ,Long id);
	List<Offre> getAll();
	Offre getOffreById(Long id);
	void affecter_Offre_Condidat(Long id_Offre,Long id_Condidat);
	Avancement getAvancement(Long id_Offre,Long id_Condidat);
	void traiter_Offre(Long id_Offre,Long id_Condidat,Avancement avancement);
	
	
	
}
