package ch.thesurvey;

import ch.thesurvey.utility.PasswordStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


/**
 * Main File
 * Here runs the application
 * Spring boot handles all the rest for us
 * @author Samuel Alfano
 * @version v0.2
 */
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class ThesurveyDemoApplication extends SpringBootServletInitializer {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ThesurveyDemoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ThesurveyDemoApplication.class, args);

		try {
			//TODO REMOVE, JUST FOR CREATING A PASSWORD -> TOTALLY INSECURE PRINTING PASSWORDS INTO LOG
			System.out.println(PasswordStorage.createHash("TestDemo1234"));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
