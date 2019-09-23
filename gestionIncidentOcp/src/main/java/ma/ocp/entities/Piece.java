package ma.ocp.entities;

import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "piece")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Piece {
	
	@Id
	private String id;
	private String marque;
	private String piece;
	private Fournisseur fournisseur;
	private Long Idtechnicien;
	

}
