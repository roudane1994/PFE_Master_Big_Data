package ma.ocp;

import java.util.stream.Stream;

import org.apache.tomcat.jni.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ma.ocp.entities.AppRole;
import ma.ocp.entities.AppUser;
import ma.ocp.entities.TechnicienForm;
import ma.ocp.entities.UserForm;
import ma.ocp.service.AccountService;

@EnableDiscoveryClient
@SpringBootApplication
public class GestionUserOcpApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionUserOcpApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder getBcr() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public CommandLineRunner start(AccountService accountService,RepositoryRestConfiguration rconf) {
	
		
		
		return args->{
			rconf.exposeIdsFor(AppUser.class);
		/**
			accountService.deleteAllUser();
			accountService.deleteAllRolle();
			
			rconf.exposeIdsFor(AppUser.class);
			accountService.saveRole(new AppRole(null,"USER"));
			accountService.saveRole(new AppRole(null,"ADMIN"));
			accountService.saveRole(new AppRole(null,"TECHNICIEN"));
			
		
			
			Stream.of("user1@ocp.ma","user2@ocp.ma","user3@ocp","admin@gmail.com").forEach(
					un->{
						UserForm user=new UserForm();
					
						user.setUsername(un);
						user.setNom("Roudane");
						user.setPrenom("rachid");
						user.setPassword("123456");
						user.setRepassword("123456");
						user.setService("AAA");
						accountService.saveUser(user);
					});
					

					Stream.of("tech1@ocp.ma","tech2@ocp.ma","tech3@ocp").forEach(
							un->{
								TechnicienForm user=new TechnicienForm();
							
								user.setUsername(un);
								user.setNom("Roudane");
								user.setPrenom("rachid");
								user.setPassword("123456");
								user.setRepassword("123456");
								user.setSpecialite("kkk");
								accountService.saveTechnicien(user);
							}
					);
					**/
			
		};
		
	}

}
