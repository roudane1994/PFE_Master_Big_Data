package ma.ocp.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "case4")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Case4 {
	
	@Id
	private String id;
	
	private String type;
	
	private String nomservice;
	
	private int dataAjoute;
	
	private int nb;

	

}
