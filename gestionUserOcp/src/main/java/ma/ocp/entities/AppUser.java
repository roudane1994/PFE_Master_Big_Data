package ma.ocp.entities;

import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class AppUser {
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(unique = true)
private String email;

private String nom;
private String prenom;
private String telephone;

private String specialite;

private String password;
private boolean actived;
private String service;

@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
private Collection<AppRole> roles=new ArrayList<>();

}
