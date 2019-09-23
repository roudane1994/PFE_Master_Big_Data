package ma.ocp;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import ma.ocp.dao.IncidentRepository;
import ma.ocp.entities.Incident;

@EnableDiscoveryClient
@SpringBootApplication
public class GestionIncidentOcpApplication {
	
   

	public static void main(String[] args) {
		SpringApplication.run(GestionIncidentOcpApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner start(IncidentRepository incidentRepository,RepositoryRestConfiguration rconf) {
		
		return args->{
			rconf.exposeIdsFor(Incident.class);
			/**
			  incidentRepository.deleteAll();
			 rconf.exposeIdsFor(Incident.class);
			
			Stream.of("AAAA","BBBB","CCCCCC","DDDDD").forEach(name->{
				
				Incident incident=new Incident(null,"aa",name, name+"aaaa", false, null, "zz",143L,null,false, "2013",null);
				incidentRepository.save(incident);
			});
			**/
		};
		
	}

}
