package ma.ocp.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.ocp.entities.Service;

@RepositoryRestResource
public interface ServiceRepository extends MongoRepository<Service,String>{

}
