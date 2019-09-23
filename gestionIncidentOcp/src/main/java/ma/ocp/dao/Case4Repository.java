package ma.ocp.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ma.ocp.entities.Case4;

public interface Case4Repository extends MongoRepository<Case4, String> {

	
	List<Case4> findAllByDataAjouteAndNomservice(int AnneeAjoute,String Nomservice);
	
	

}