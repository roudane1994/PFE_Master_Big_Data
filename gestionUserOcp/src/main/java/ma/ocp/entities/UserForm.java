package ma.ocp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public @Data @AllArgsConstructor @NoArgsConstructor
class UserForm {
private String username="vide";
private String nom;
private String prenom;
private String telephone;
private String password;
private String repassword;
private String service;
}