package tn.esprit.spring.PDFF;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

@Service
public class PDFFileService {
	
	
	public void pdfCreation()
	{
		String filepath="C:\\PdfFiles\\simple2.pdf";
		
		try {
			PdfWriter writer=new PdfWriter(filepath);
			
			PdfDocument pdfdoc=new PdfDocument(writer);
			pdfdoc.addNewPage();
			
			Document document=new Document(pdfdoc);
			document.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	

}
