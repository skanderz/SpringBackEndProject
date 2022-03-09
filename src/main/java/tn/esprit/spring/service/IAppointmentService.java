package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Appointement;



public interface IAppointmentService {
	public void addAppointement(Appointement complaint);
public 	void deleteAppointement(Long id);
	public Appointement updateAppointement(Appointement c);
	public Optional<Appointement> retrieveAppointement(Long id);
	public List<Appointement> retrieveAllAppointements();
}
