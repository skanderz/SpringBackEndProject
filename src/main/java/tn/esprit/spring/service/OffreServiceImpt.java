package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Avancement;
import tn.esprit.spring.entity.Condidat;
import tn.esprit.spring.entity.Offre;
import tn.esprit.spring.repository.CondidatRepository;
import tn.esprit.spring.repository.OffreRepository;
@Service
public class OffreServiceImpt  implements OffreService{
	@Autowired
	OffreRepository offreRepository;
	@Autowired 
	CondidatService condidatService;
	@Autowired
	CondidatRepository condidatRepository;

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		offreRepository.deleteById(id);
	}

	@Override
	public Offre create(Offre o) {
		// TODO Auto-generated method stub
		return offreRepository.save(o);
	}

	@Override
	public Offre update(Offre o, Long id) {
		// TODO Auto-generated method stub
		Offre offre_To_update = offreRepository.findById(id).orElse(null);
		
		
		return offreRepository.save(offre_To_update);
	}

	@Override
	public List<Offre> getAll() {
		// TODO Auto-generated method stub
		return offreRepository.findAll();
	}

	@Override
	public Offre getOffreById(Long id) {
		// TODO Auto-generated method stub
		return offreRepository.findById(id).orElse(null);
	}

	
	/*public void affecter_Offre_Condidat(Long id_Offre, Long id_Condidat) {
		// TODO Auto-generated method stub
	Condidat cond=	condidatService.getCondidatById(id_Condidat);
	Offre off=getOffreById(id_Offre);*/
	
	
	@Override
	public void affecter_Offre_Condidat(Long id_Offre, Long id_Condidat) {
		Offre o = new Offre();
		Condidat c = new Condidat();
		o = offreRepository.getById(id_Offre);
		c = condidatRepository.findById(id_Condidat).orElse(null);
		
		c.setOffre(o);
		condidatRepository.save(c);  
		}

		
	
	

	@Override
	public Avancement getAvancement(Long id_Offre, Long id_Condidat) {
		// TODO Auto-generated method stub
		Avancement avancement = null;
		Condidat cond=	condidatService.getCondidatById(id_Condidat);
		Offre off=getOffreById(id_Offre);
    avancement=cond.getAvancement();  
       
		
		return avancement;
	}



	@Override
	public void traiter_Offre(Long id_Offre, Long id_Condidat,Avancement av) {
		// TODO Auto-generated method stub
		Condidat cond=	condidatService.getCondidatById(id_Condidat);
		Offre off=getOffreById(id_Offre);
		

		cond.setAvancement(av);
	
		
		
	}

}
