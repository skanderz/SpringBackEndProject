package tn.esprit.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entity.Subscription;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;
@Slf4j
@Service
public class UserServiceImpl implements UserService {

	
	@Autowired	UserRepository UserRepo;

	
	@Override	public List<User> retrieveAllUsers() {	 return (List<User>) this.UserRepo.findAll();		}
	@Override   public User addUser(User c)          {	 return this.UserRepo.save(c);						}
	@Override	public void deleteUser(Long id)      {	 this.UserRepo.deleteById(id);						}
	@Override	public User updateUser(User c)       {	 return this.UserRepo.save(c);						}
	@Override	public User retrieveUser(Long id)    {	 return this.UserRepo.findById(id).orElse(null);	}

	@Override   public int DisableAccount(Long idUser) { return  UserRepo.DisableAccount(idUser);   }
	@Override   public int EnableAccount(Long idUser)  { return  UserRepo.EnableAccount(idUser);   }
	
	@Override   public int ChangePassword(Long idUser,String Password)  { return  UserRepo.ChangePassword(idUser,Password);   } 
	@Override   public int AddSolde(Long idUser,double AddedSolde)  { return  UserRepo.AddSolde(idUser,AddedSolde);   } 

	
	

	
	

	
	
	

	




	

	







	
	
	
	
		
	

}
