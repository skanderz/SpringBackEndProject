package tn.esprit.spring.service;

import java.time.LocalDateTime;
import java.util.List;

import tn.esprit.spring.entity.Reclamation;

public interface ReclamationService {
	public Reclamation create(Reclamation rec, Long u, Long o);

	public List<Reclamation> findall();

	public Reclamation findbyid(long rec_id);

	public void delete(long id);

	public Reclamation update(Reclamation rec, long rec_id);

	void traiter(Long rec, String reponse);

	public List<Object[]> ReclamtionPerDayEtat(Integer date);

	public Boolean badWordsValidation(String[] wordsFromText);

	public List<Reclamation> filter(String filter);

	public List<Reclamation> findBetweenDate(LocalDateTime start, LocalDateTime end);

	public List<Reclamation> findMyReclam(int id);

	public List<Reclamation> searchMultiCriteria(String filter, String type, boolean mine, LocalDateTime start,
			LocalDateTime end, boolean treated, int id);

}
