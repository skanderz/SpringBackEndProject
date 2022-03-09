package tn.spring.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import tn.spring.Entities.Complaint;

public interface IComplaintService {
	public void addComplaint(Complaint complaint);
public 	void deleteComplaint(Long id);
	public Complaint updateComplaint(Complaint c);
	public Optional<Complaint> retrieveComplaint(Long id);
	public List<Complaint> retrieveAllComplaints();
	List<Complaint> listeComplaints(Long idUser) ;
	public List<Complaint> findComplaintWithSorting(String field);
	public Page<Complaint> findComplaintsWithPagination(int offset,int pageSize);
	public Optional<Complaint> retrieveComplaints(Long idComplaint);
}
