package tn.esprit;

import javax.mail.MessagingException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tn.esprit.configuration.FileStorageProperties;


@EnableAspectJAutoProxy
@EnableScheduling
@EnableWebMvc

@EnableConfigurationProperties({ FileStorageProperties.class})
@SpringBootApplication
public class Pi2022BackEndApplication {

	
	
		public static void main(String[] args) {
			SpringApplication.run(Pi2022BackEndApplication.class, args);
			System.out.println("Le nombre des  space active est : 2 ");
			System.out.println("Le nombre des  space Nonactive est : 1 ");


		}
		
		
		
		
		
		
		
		
		

}
