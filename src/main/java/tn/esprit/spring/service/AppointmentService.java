package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Appointement;
import tn.esprit.spring.repository.AppointementRepo;




@Service
public class AppointmentService implements IAppointmentService{
	@Autowired
   AppointementRepo appointmentRepo;

	@Override
	public void addAppointement(Appointement app) {
		appointmentRepo.save(app);
		
	}

	@Override
	public void deleteAppointement(Long id) {
		appointmentRepo.deleteById(id);
		
	}

	@Override
	public Appointement updateAppointement(Appointement app) {
		return appointmentRepo.save(app);
		
		
	}
	@Override
	public List<Appointement> retrieveAllAppointements() {
		return (List<Appointement>) appointmentRepo.findAll();
	}

	@Override
	public Optional<Appointement> retrieveAppointement(Long id) {
		return appointmentRepo.findById((long) id) ;

	}
	
}
