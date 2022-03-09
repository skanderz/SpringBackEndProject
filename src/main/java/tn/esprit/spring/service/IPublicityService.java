package tn.esprit.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;

import tn.esprit.spring.entity.Publicity;
import tn.esprit.spring.entity.User;




public interface IPublicityService {

	public Publicity ajouterPublicity(Publicity pub);
	public Publicity modifierPublicity(Publicity pub);
	public void deletePublicity(Integer IdPub );
	public List<Publicity> retreiveAllPub();
	public Page<Publicity> findComplaintsWithPagination(int offset,int pageSize);
	public Publicity retrievePublicity(int IdPub);
}
