package ma.ocp.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "case2")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Case2 {
	
	@Id
	private String id;
	
	private String type;
	
	private int dataAjoute;
	
	private int nb;

	
	
	

}
