package ma.ocp.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FournisseurRepository extends MongoRepository<FournisseurRepository,String> {

}
