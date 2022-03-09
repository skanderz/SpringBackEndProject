package tn.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.repositories.FeedBackUserRepository;

@Service
public class FeedBackUserServiceImpl implements IFeedBackUserService{
@Autowired
 FeedBackUserRepository    feedbackuserRepository;
	
	@Override
	public float SommeNote(Long userId) {
		return feedbackuserRepository.SommeNote(userId);

	}

}
