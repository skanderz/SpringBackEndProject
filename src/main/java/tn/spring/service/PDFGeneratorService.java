package tn.spring.Services;




import java.io.FileNotFoundException;

import org.springframework.stereotype.Service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

@Service
public class PDFGeneratorService {
	
	
	public void pdfCreation()
	{
		String filepath="C:\\Users\\DELL\\Desktop\\PdfFiles\\sa.pdf";
		
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