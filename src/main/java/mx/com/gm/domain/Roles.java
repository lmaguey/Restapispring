

package mx.com.gm.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity(name="roles")
@Table(name="roles")
public class Roles implements Serializable {
    
    private static final long serialVersionUID=1L;
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   
   private String nombre;
   
   private int id_usuario;
    
}
