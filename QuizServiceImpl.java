package tn.spring.services;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import tn.spring.entities.Qcm;
import tn.spring.repositories.QcmRep;


@Service
@Slf4j
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	QcmRep qcmRep;

	@Override
	public List<Qcm> retrieveAllQcm() {
		 log.info("Quiz are Retrieved Successfully");
			
			return (List<Qcm>) qcmRep.findAll();
	}
	
	public List<Qcm> findQcmswithSorting(String field){
		return qcmRep.findAll(Sort.by(Sort.Direction.DESC,field));
	}
		

	@Override
	public Qcm addQcm(Qcm q) {
		log.info("The course is saved");
		return 		qcmRep.save(q);
	}

	@Override
	public void deleteQcm(Integer id) {
		log.info("Deleting Quiz ");
		 qcmRep.deleteById(id);
		
	}

	@Override
	public Qcm updateQcm(Qcm q) {
		log.info("Update Course");
        return qcmRep.save(q);
	}

	@Override
	public Optional<Qcm> retrieveQcm(Integer id) {
		log.info("Quiz is Retrieved Successfully");
		return qcmRep.findById(id) ;
	}

	@Override
	public Page<Qcm> findQcmsWithPagination(int offset, int pageSize) {
		Page<Qcm> qcms = qcmRep.findAll(PageRequest.of(offset, pageSize));
	    return  qcms;
	}
	
	
	
	
	


}

	
	
