package tn.spring.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import tn.spring.entities.CourseDto;
import tn.spring.entities.Courses;
import tn.spring.entities.Formers;
import tn.spring.repositories.CoursesRepository;
import tn.spring.repositories.FormersRepository;

                                     

@Service
public class CoursesService  {
	@Autowired
	private CoursesRepository courseDao;
	@Autowired
	private FormersRepository formerDao;

	
	
	
public Courses update(CourseDto coursee) throws ParseException {
		
		Courses course = courseDao.findById(coursee.getId()).get();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    Date parsed = format.parse(coursee.getDateDebut());
	    java.sql.Date datedebut = new java.sql.Date(parsed.getTime());
	    Date parsed2 = format.parse(coursee.getDateFin());
	    java.sql.Date datefin = new java.sql.Date(parsed2.getTime());
	  
		
	    course.setDateDebut(datedebut);
	    course.setDateFin(datefin);
	    course.setDescription(coursee.getDescription());
	    course.setEtat(coursee.getEtat());
		course.setTitre(coursee.getTitre());
		course.setPrix(coursee.getPrix());
		
		return courseDao.save(course);
	}
	

	public String affectation(CourseDto coursee) {
		Formers former = formerDao.findById(coursee.getIdFormer()).get();
		Courses course = courseDao.findById(coursee.getId()).get();
		Calendar datedcour = Calendar.getInstance();
		
		datedcour.setTime(course.getDateDebut());
	    
		Calendar datefcour = Calendar.getInstance();
		datefcour.setTime(course.getDateFin());
		
		
		
		
	
		Object[] coursesArray = former.getCourses().toArray();
		

		int nb = 0;
		for (Object element : coursesArray) {
			
				Calendar dated = Calendar.getInstance();
			    dated.setTime(((Courses)element).getDateDebut());
			    
				Calendar datef = Calendar.getInstance();
			    datef.setTime(((Courses)element).getDateFin());
			    if( ((dated.before(datedcour)||dated.equals(datedcour))&&(datedcour.before(datef)||datef.equals(datedcour))) || ((dated.before(datefcour)||dated.equals(datefcour))&&(datefcour.before(datef)||datef.equals(datefcour))) ) {
			    	nb++;
			    }
		}
		if(1<nb) {
			return "Former Cant have more than 2 courses in the same period";
		}else {
			course.setFormer(former);
			courseDao.save(course);
			return "Done";
		}
		
	}
	
	
	

	
	
	
	
}