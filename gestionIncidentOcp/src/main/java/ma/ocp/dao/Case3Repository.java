package ma.ocp.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import ma.ocp.entities.Case3;


public interface Case3Repository extends MongoRepository<Case3, String> {
	
	List<Case3> findAllByType(String Type);
	
	List<Case3> findAllByDataAjoute(int AnneeAjoute);
	
	List<Case3> findAllByDataAjouteAndType(int AnneeAjoute,String Type);
	
	

}