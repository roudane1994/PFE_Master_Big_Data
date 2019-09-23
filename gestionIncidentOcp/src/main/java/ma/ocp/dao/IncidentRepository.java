package ma.ocp.dao;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


import ma.ocp.entities.Incident;


@RepositoryRestResource
public interface IncidentRepository extends MongoRepository<Incident,String> {
	
	@RestResource(path = "/userIncidentUserIdAgent")
	List<Incident> findAllByIdagent(@Param("idagent") Long idagent );
	
	@RestResource(path = "/userIncidentUserIdAgentEtat")
	List<Incident> findAllByIdagentAndEtat(@Param("idagent") Long agent,@Param("etat") boolean etat);
	@RestResource(path = "/userIncidentUserTypeEtat")
	Page<Incident> findAllByTypeAndEtat(@Param("type") String Type,@Param("etat") boolean etat,PageRequest p);
	
	@RestResource(path = "/incidentValider")
	Page<Incident> findByEtatIsTrue(PageRequest p);
	
	@RestResource(path = "/incidentNonValider")
	Page<Incident> findByEtatIsFalse(PageRequest p);
	
	@RestResource(path = "/technicienincidentValider")
	List<Incident> findByTypeAndEtatIsTrue(@Param("type") String Type);
	
	@RestResource(path = "/technicienincidentNonValider")
	List<Incident> findByTypeAndEtatIsFalse(@Param("type") String Type);
	
	
	
	Page<Incident> findAllByEtat(int etat,PageRequest p);

}
