

package mx.com.gm.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity(name="puntos")
@Table(name="puntos")
public class Puntos implements Serializable {
    
    private static final long serialVersionUID=1L;
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   
   private int id_usuario;
   
   private int cantidad;
    
}
