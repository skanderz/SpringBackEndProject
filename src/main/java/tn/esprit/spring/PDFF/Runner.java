package tn.esprit.spring.PDFF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;



@Component
public class Runner implements ApplicationRunner {

	private PDFFileService pdfFileService;

	@Autowired
	public Runner(PDFFileService pdfFileService) {
		
		this.pdfFileService = pdfFileService;
	}
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		System.out.println("Application Started to Run");
		pdfFileService.pdfCreation();
		System.out.println("Pdf File Got Created");
		
		System.out.println("");

		
		
	}

}
