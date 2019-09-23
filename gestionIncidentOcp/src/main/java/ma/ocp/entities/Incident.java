package ma.ocp.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "incident")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Incident {
	
	@Id
	private String id;
	@NotNull(message = "selectionner le type d'incident")
	private String type;
	@NotNull
	@Size(max =25,min = 3)
	private String titre;
	@NotNull
	@Size(max =250,min = 3)
	private String description;
	private boolean exitImg=false;
	private String extention;
	private String materiel;

	private Long idagent;
	private Long idtechnicien;
	private boolean etat;
    private String dataAjoute;
	private String dataClouture;
	
	
	

	
	
	
	
	
	

	

	

	

	

	

}
