package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.FeedBackUserRepository;


@Service
public class FeedBackUserServiceImpl implements IFeedBackUserService{
@Autowired
 FeedBackUserRepository    feedbackuserRepository;
	
	@Override
	public float SommeNote(Long userId) {
		return feedbackuserRepository.SommeNote(userId);

	}

}
