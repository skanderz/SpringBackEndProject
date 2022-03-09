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
public class CondidatServiceImpt implements CondidatService{
	
	@Autowired
	CondidatRepository condidatRepository;
	@Autowired
	OffreRepository offreRepository;
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		condidatRepository.deleteById(id);
	}

	@Override
	public Condidat create(Condidat c) {
		// TODO Auto-generated method stub
		c.setAvancement(Avancement.ENATTENTE);
		return condidatRepository.save(c);
	}

	@Override
	public Condidat update(Condidat c) {	return this.condidatRepository.save(c);	}

	@Override
	public List<Condidat> getAll() {
		// TODO Auto-generated method stub
		return condidatRepository.findAll();
	}

	@Override
	public Condidat getCondidatById(Long id) {
		// TODO Auto-generated method stub
		return condidatRepository.findById(id).orElse(null);
	}

	@Override
	public void traiteravancement(String av, Long cond) {
		// TODO Auto-generated method stub
		
		Condidat condidat=	condidatRepository.findById(cond).orElse(null);
		
		condidat.setAvancement(Avancement.valueOf(av));
		
		condidatRepository.save(condidat);
	}



}
