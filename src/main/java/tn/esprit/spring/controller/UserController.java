package tn.esprit.spring.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;

import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Subscription;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.UserService;
import tn.esprit.spring.service.UserServiceImpl;


@RestController
@RequestMapping("/User")
public class UserController {


@Autowired   UserService UserService;
private static String  QR_CODE_IMAGE_PATH ="path";

	



public int nbrRandom()
{   
	List<User> UL = UserService.retrieveAllUsers();
	Random random = new Random();   boolean test=false; int t=0;
    int nb = 0 ,borneInf = 10000000 ,borneSup = 99999999; 
	while (test==false){   nb = borneInf+random.nextInt(borneSup-borneInf);
    for(User u : UL){      if(nb == u.getIdentifiant())  t=1; }  if(t==0) test=true;   }     
	return nb; }



	
@PostMapping("/add-User")
@ResponseBody
public User addUser(@RequestBody User u)  {  
	QR_CODE_IMAGE_PATH = "./src/main/resources/QR-CODE-USERLIST/" + "QRCode - "+  u.getUsername()  + ".png";
	try {QRCodeGenerator2.generateQRCodeImage( u.getUsername(), 500, 500, QR_CODE_IMAGE_PATH); } catch (WriterException | IOException e) {e.printStackTrace();}              
	int idnbr = nbrRandom();       u.setIdentifiant(idnbr);  
	u.setSolde(0);
	if (u.getPassword().length() < 7) {  throw new ArithmeticException("le mot de passe doit contenir au minimum 7 caractere !!");  }
	return UserService.addUser(u); }
	



@PutMapping("/ChangePassword/{idUser}/{OldPassword}/{NewPassword}/{VerifNewPassword}")
@ResponseBody
public int ChangePassword(@PathVariable Long idUser ,@PathVariable(name = "OldPassword") String OldPassword 
	                     ,@PathVariable(name = "NewPassword") String NewPassword ,@PathVariable(name = "VerifNewPassword") String VerifNewPassword   )
{	
List<User> UL = UserService.retrieveAllUsers();  int test = 0; int test2 = 0 ;
   if (NewPassword.length() < 7) {  throw new ArithmeticException("le mot de passe doit contenir au minimum 7 caractere !!");  }
     for (User u : UL) { if(u.getIduser() == idUser)  { if (u.getPassword().equals(OldPassword)) test=1; }}
     if (test==0) {  throw new ArithmeticException("Ancient mot de passe saisie incorrect");  }
       if ( VerifNewPassword.equals(NewPassword) )  test2 = 1 ;   
       if ( test2 == 0 ) {  throw new ArithmeticException("Confirmation du mot de passe incorrect");}	
return  UserService.ChangePassword(idUser ,NewPassword);	}


	



// http://localhost:8075/SpringMVC/User/retrieve-all-Users
@GetMapping("/retrieve-all-Users")
@ResponseBody
public List<User> getUsers() {  List<User> listUsers = UserService.retrieveAllUsers();  return listUsers;}



// http://localhost:8075/SpringMVC/User/retrieve-User/8
@GetMapping("/retrieve-User/{User-id}")
@ResponseBody
public User retrieveUser(@PathVariable("User-id") Long UserId) {   return UserService.retrieveUser(UserId);  }



// http://localhost:8075/SpringMVC/client/modify-client
@PutMapping("/modify-User")
@ResponseBody
public User modifyUser(@RequestBody User User) {   return UserService.updateUser(User);  }



// http://localhost:8075/SpringMVC/client/remove-client/{client-id}
@DeleteMapping("/remove-User/{User-id}")
@ResponseBody
public void removeUser(@PathVariable("User-id") Long UserId) {   UserService.deleteUser(UserId); }






@PutMapping("/DisableAccount/{idUser}")
@ResponseBody
public int DisableAccount(@PathVariable Long idUser  ) { return  UserService.DisableAccount(idUser);	}



@PutMapping("/EnableAccount/{idUser}")
@ResponseBody
public int EnableAccount(@PathVariable Long idUser  ) {	return  UserService.EnableAccount(idUser);	}


@PutMapping("/Solde/{idUser}/{AddedSolde}")
@ResponseBody
public int AddSolde(@PathVariable Long idUser ,@PathVariable("AddedSolde") float AddedSolde ) {	
	List<User> UL = UserService.retrieveAllUsers();  float s=0;
	for (User u : UL) { if(u.getIduser() == idUser) {  s=u.getSolde() + AddedSolde; }}
	return UserService.AddSolde(idUser,s);}







}






