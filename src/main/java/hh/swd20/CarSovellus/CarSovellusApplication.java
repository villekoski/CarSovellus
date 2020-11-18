package hh.swd20.CarSovellus;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import hh.swd20.CarSovellus.domain.Car;
import hh.swd20.CarSovellus.domain.CarRepository;
import hh.swd20.CarSovellus.domain.Owner;
import hh.swd20.CarSovellus.domain.OwnerRepository;
import hh.swd20.CarSovellus.domain.User;
import hh.swd20.CarSovellus.domain.UserRepository;



@SpringBootApplication
public class CarSovellusApplication extends SpringBootServletInitializer implements WebMvcConfigurer {
	private static final Logger log = LoggerFactory.getLogger(CarSovellusApplication.class);

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CarSovellusApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CarSovellusApplication.class, args);
	}
	
	@Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
	
	
	@Bean
    public CommandLineRunner demo(CarRepository carRepository, OwnerRepository ownerRepository, UserRepository uRepository) {
        return (args) -> {	
        	
        	
        	Owner eka = new Owner("Timo Jutila");
            Owner toka = new Owner("Bob Marley");
            Owner kolmas = new Owner("Hannu Kerttu");
            ownerRepository.save(eka);
            ownerRepository.save(toka);
            ownerRepository.save(kolmas);
             
            Car b1 = new Car("Bugatti Veyron", "Suomi", 1990, "Ihan ookoo auto!", 200000.0, eka );
            Car b2 = new Car("Taxi Auto", "Nigeria", 2010, "Kulkee kulkee", 10.0, toka);
            Car b3 = new Car("Raktori", "Venäjä", 1890, "Davai davai", 11200.0, kolmas);
            
            carRepository.save(b1);
            carRepository.save(b2);
            carRepository.save(b3);
            
           User user1 = new User("Matti1", "$2b$10$Bz9wToqfoDIvD8cP8rZTteiZx7HIly8fglEajwUS9ctv8r/OK7g6i", "ROLE_USER");
            User user2 = new User("CARLOVER666", "$2b$10$uxmkJ9AxEWiMyuxTteJgYOvryVwzOjq805hIbVHC37.9H8V.Aq9ya", "ROLE_ADMIN");
        	uRepository.save(user1);
        	uRepository.save(user2);
     
            for (Car car : carRepository.findAll()) {
                log.info(car.toString());
            }
            for (Owner owner : ownerRepository.findAll()) {
                log.info(owner.toString());
            }
        for (User user : uRepository.findAll()) {
                log.info(user.toString());
            }
        };
    }
}