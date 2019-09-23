package ma.ocp.entities;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "fournisseur")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fournisseur {
	
	@Id
	private String id;
	@NotNull
	private String nom;
	@NotNull
	private String email;
	@NotNull
	private String telephone;
	@NotNull
	private String specialite;
	
}
