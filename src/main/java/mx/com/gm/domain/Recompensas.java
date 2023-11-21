

package mx.com.gm.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity
@Table(name="recompensas")
public class Recompensas implements Serializable {
    
    private static final long serialVersionUID=1L;
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   
   private String nombre_recompensa;
   
   private int valor_en_puntos;
    
}
