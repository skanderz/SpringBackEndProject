package tn.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;


import tn.spring.entities.Publicity;

public interface IPublicityService {

	public Publicity ajouterPublicity(Publicity pub);
	public Publicity modifierPublicity(Publicity pub);
	public void deletePublicity(Integer IdPub );
	public List<Publicity> retreiveAllPub();
	public Page<Publicity> findComplaintsWithPagination(int offset,int pageSize);
}
