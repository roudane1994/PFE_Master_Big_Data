package ma.ocp.dao;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ma.ocp.entities.AppUser;




@RepositoryRestResource
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	
	@RestResource(path = "/userAvecEmail")
	AppUser findByEmail(@Param("email") String email);
	
	
	
	@RestResource(path = "/agentsActive")
	Page findByActivedIsTrueAndServiceIsNotNull(Pageable p);
	
	@RestResource(path = "/agentsNonActive")
	Page findByActivedIsFalseAndServiceIsNotNull(Pageable p);
	
	@RestResource(path = "/techniciensActive")
	Page findByActivedIsTrueAndServiceIsNull(Pageable p);
	
	@RestResource(path = "/techniciensNonActive")
	Page findByActivedIsFalseAndServiceIsNull(Pageable p);
	
	
	
}
