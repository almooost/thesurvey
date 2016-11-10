package ch.thesurvey;

import ch.thesurvey.utility.PasswordStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class ThesurveyDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThesurveyDemoApplication.class, args);

		try {
			System.out.println(PasswordStorage.createHash("TestDemo1234"));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
