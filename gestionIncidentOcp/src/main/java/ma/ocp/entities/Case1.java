package ma.ocp.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "case1")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Case1 {
	
	@Id
	private String id;
	
	private int annee;
	
	private int nb;

	

}