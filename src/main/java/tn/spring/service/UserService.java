package tn.esprit.spring.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.Subscription;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;



public interface UserService {

	
	List<User> retrieveAllUsers();
	User addUser(User c);
	void deleteUser(Long id);
	User updateUser(User c);
	User retrieveUser(Long id);
	int DisableAccount(Long idUser);   
	int EnableAccount(Long idUser);
	int ChangePassword(Long idUser,String Password);
	int AddSolde(Long idUser,double s);

}


