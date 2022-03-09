package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import tn.esprit.spring.entity.Qcm;


public interface QuizService {
	List<Qcm>retrieveAllQcm();
	Qcm addQcm (Qcm q);
	void deleteQcm (Integer id);
	Qcm updateQcm (Qcm q);
	Optional<Qcm> retrieveQcm (Integer id);
	public  List<Qcm> findQcmswithSorting(String field);
	public Page<Qcm> findQcmsWithPagination(int offset,int pageSize);
	
}
