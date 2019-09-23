package ma.ocp.entities;

import javax.persistence.*;
import lombok.*;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class AppRole {
@Id 
@GeneratedValue(strategy =GenerationType.IDENTITY)
private Long id;
private String roleName;
}