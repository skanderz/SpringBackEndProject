package tn.spring.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;



import tn.spring.entities.Publicity;
import tn.spring.entities.Status;
import tn.spring.entities.Type;
import tn.spring.entities.Typee;
import tn.spring.repository.PublicityRepository;

@Service
public class PublicityService implements IPublicityService{

	
	@Autowired
	PublicityRepository publicityRepository;
	
	
	@Override
	public Publicity ajouterPublicity(Publicity pub) {
		return publicityRepository.save(pub);
		
	}
	@Override
	public Publicity modifierPublicity(Publicity pub)
	{
		return publicityRepository.save(pub);
	}
	@Override
	public void deletePublicity(Integer IdPub) {
		publicityRepository.deleteById(IdPub);
		
	}
	@Override
	public List<Publicity> retreiveAllPub() {
		
		return (List<Publicity>) publicityRepository.findAll();
	}
	


	public Page<Publicity> findComplaintsWithPagination(int offset,int pageSize){
	    Page<Publicity> publicitys = publicityRepository.findAll(PageRequest.of(offset, pageSize));
	    return  publicitys;

	}
	
	@Scheduled(cron="*/15 * * * * *")
	public 	void typeparType(){
			int nbrImage=publicityRepository.getPublicityByType(Type.Image);
			int nbrVideo=publicityRepository.getPublicityByType(Type.Video);
			
			System.out.println("nombre des publicité de type image:"+nbrImage);
			System.out.println("nombre des publicité de type video:"+nbrVideo);
			
			
			
		}

}
