package tn.esprit.spring.service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tn.esprit.spring.config.OpenNLP;
import tn.esprit.spring.entity.Condidat;
import tn.esprit.spring.entity.Offre;
import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.RestrictWord;
import tn.esprit.spring.repository.CondidatRepository;
import tn.esprit.spring.repository.OffreRepository;
import tn.esprit.spring.repository.ReclamationRepository;

@Service
public class ReclamationServiceImpt implements ReclamationService {

	@Autowired
	ReclamationRepository reclamationRepository;

	@Autowired
	CondidatRepository condidatrep;;
	@Autowired
	OffreRepository offreRepository;
	@Autowired
	RestrictWordService restrictWordService;

	@Override
	public Reclamation create(Reclamation rec, Long u, Long o) {
		// TODO Auto-generated method stub
		Condidat us = condidatrep.findById(u).get();
		Offre off = offreRepository.findById(o).get();
		rec.setReponse(null);
		OpenNLP model = new OpenNLP();
		// PreTrained Recrusive Neural Networl to return the sentimet based on text
		rec.setPriority(model.findSentiment(rec.getDescription()));
		rec.setOffre(off);
		rec.setTraiter(false);
		rec.setEtat("En_attente");
		rec.setCondidat(us);
		rec.setDateRec(LocalDateTime.now());
		return reclamationRepository.save(rec);

	}

	@Override
	public List<Reclamation> findall() {
		// TODO Auto-generated method stub
		return reclamationRepository.findAll(Sort.by(Sort.Direction.ASC, "priority"));
	}

	@Override
	public Reclamation findbyid(long rec_id) {
		// TODO Auto-generated method stub
		return reclamationRepository.getById(rec_id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		reclamationRepository.deleteById(id);

	}

	@Override
	public Reclamation update(Reclamation rec, long rec_id) {
		// TODO Auto-generated method stub
		Reclamation recToUpdate = reclamationRepository.getById(rec_id);

		recToUpdate.setDateRec(rec.getDateRec());
		recToUpdate.setDescription(rec.getDescription());
		recToUpdate.setReponse(rec.getReponse());
		recToUpdate.setTitre(rec.getTitre());

		return reclamationRepository.save(recToUpdate);
	}

	@Override
	public void traiter(Long rec, String reponse) {
		// TODO Auto-generated method stub
		Reclamation recTotraiter = reclamationRepository.getById(rec);
		recTotraiter.setEtat("traiter");
		recTotraiter.setReponse(reponse);
		recTotraiter.setTraiter(true);

		reclamationRepository.save(recTotraiter);

	}

	@Override
	public List<Reclamation> findMyReclam(int id) {
		return reclamationRepository.findMyReclams((long) id).stream()
				.sorted(Comparator.comparing(Reclamation::getDateRec)).collect(Collectors.toList());
	}

	@Override
	public List<Object[]> ReclamtionPerDayEtat(Integer date) {
		// TODO Auto-generated method stub
		return reclamationRepository.ReclamtionPerDayEtat(date);
	}

	@Override
	public List<Reclamation> searchMultiCriteria(String filter, String type, boolean mine, LocalDateTime start,
			LocalDateTime end, boolean treated, int id) {
		List<Reclamation> reclamations;
		if (mine) {
			reclamations = findMyReclam(id);
		} else {

			reclamations = findall();
		}

		if (!filter.isEmpty()) {
			reclamations = reclamations.stream().filter(x -> x.getTitre().toLowerCase().contains(filter.toLowerCase()))
					.collect(Collectors.toList());
		}

//		if (start != null && end != null) {
//			reclamations = reclamations.stream()
//					.filter(x -> x.getDateRec().isAfter(start) && x.getDateRec().isBefore(end))
//					.collect(Collectors.toList());
//		}
		if (treated) {
			reclamations = reclamations.stream().filter(Reclamation::isTraiter).collect(Collectors.toList());
		}

		return reclamations;

	}

	@Override
	public List<Reclamation> filter(String filter) {
		return reclamationRepository.findByFilter(filter).stream()
				.sorted(Comparator.comparing(Reclamation::getPriority)).collect(Collectors.toList());
	}

	@Override
	public List<Reclamation> findBetweenDate(LocalDateTime start, LocalDateTime end) {
		return reclamationRepository.findBetweenDate(start, end).stream()
				.sorted(Comparator.comparing(Reclamation::getPriority)).collect(Collectors.toList());
	}

	@Override
	public Boolean badWordsValidation(String[] wordsFromText) {
		List<RestrictWord> restrictWords = restrictWordService.findAll();
		Boolean thatsOk = true;
		if (!restrictWords.isEmpty())
			for (int i = 0; i < wordsFromText.length; i++) {
				String wordFromText = wordsFromText[i];
				if (restrictWords.stream().filter(word -> word.getWord().equalsIgnoreCase(wordFromText)).count() > 0) {
					thatsOk = false;
					break;
				}
			}
		return thatsOk;
	}

}
