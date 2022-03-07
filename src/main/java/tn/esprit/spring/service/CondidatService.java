package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Condidat;
import tn.esprit.spring.entity.Offre;

public interface CondidatService {
	
	void delete(Long idCondidat);
	Condidat create(Condidat c);
	Condidat update(Condidat c ,Long idCondidat);
	List<Condidat> getAll();
	Condidat getCondidatById(Long idCondidat);

}
