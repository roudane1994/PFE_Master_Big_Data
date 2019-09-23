package ma.ocp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import ma.ocp.entities.Case2;
;

public interface Case2Repository extends MongoRepository<Case2, String> {
	
	List<Case2> findAllByType(String Type);
	
	List<Case2> findAllByDataAjoute(int AnneeAjoute);

}
