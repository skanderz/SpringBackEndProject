package tn.spring.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.spring.Entities.Complaint;
import tn.spring.Entities.Status;
import tn.spring.Entities.User;
import tn.spring.Repository.ComplaintRepo;
import tn.spring.Repository.UserRepo;

@Service
public class ComplaintService implements IComplaintService{
@Autowired
ComplaintRepo complaintRepo;
@Autowired
UserRepo userRepo;
@Override
public void addComplaint(Complaint complaint) {
	complaintRepo.save(complaint);
	
}

@Override
public void deleteComplaint(Long id) {
	complaintRepo.deleteById(id);
	
}

@Override
public Complaint updateComplaint(Complaint c) {
	return complaintRepo.save(c);
	
	
}
@Override
public List<Complaint> retrieveAllComplaints() {
	return (List<Complaint>) complaintRepo.findAll();
}

@Override
public Optional<Complaint> retrieveComplaint(Long id) {
	return complaintRepo.findById((long) id) ;

}
//liste de reclamations d'un user donneé 
@Override
public List<Complaint> listeComplaints(Long idUser) 
	{
		User u =userRepo.findById(idUser).orElse(null);
	    return complaintRepo.findByUser(u);
	}
@Override
public List<Complaint> findComplaintWithSorting(String field){
	return complaintRepo.findAll(Sort.by(Sort.Direction.DESC,field));
}
public Page<Complaint> findComplaintsWithPagination(int offset,int pageSize){
    Page<Complaint> complaints = complaintRepo.findAll(PageRequest.of(offset, pageSize));
    return  complaints;

}

@Override
	public Optional<Complaint> retrieveComplaints(Long idComplaint) {
		return complaintRepo.findById((long) idComplaint) ;
	}
@Scheduled(cron="*/15 * * * * *")
public 	void nbrereclamationsparstatus(){
		int nbrBEINGTREATED=complaintRepo.getComplaintByStatus(Status.BEINGTREATED);
		int nbrTREATED=complaintRepo.getComplaintByStatus(Status.TREATED);
		int nbrNOTTREATED=complaintRepo.getComplaintByStatus(Status.NOTTREATED);
		System.out.println("nombre des reclamations beingtreated:"+nbrBEINGTREATED);
		System.out.println("nombre des reclamations TREATED:"+nbrTREATED);
		System.out.println("nombre des reclamations NOTTREATED:"+nbrNOTTREATED);
		
		
	}


}
