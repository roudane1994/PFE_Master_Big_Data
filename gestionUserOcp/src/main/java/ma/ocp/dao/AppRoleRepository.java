package ma.ocp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import ma.ocp.entities.AppRole;


@RepositoryRestResource
public interface AppRoleRepository extends JpaRepository<AppRole,Long>{
public AppRole findByRoleName(String rolename);
}
