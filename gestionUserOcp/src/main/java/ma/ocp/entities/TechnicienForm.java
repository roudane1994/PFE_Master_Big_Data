package ma.ocp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechnicienForm {
	
	private String username;
	private String nom;
	private String prenom;
	private String telephone;
	private String specialite;
	private String password;
	private String repassword;

}
