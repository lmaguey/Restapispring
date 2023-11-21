
package mx.com.gm.servicios;

import java.util.List;
import mx.com.gm.domain.Puntos;
import mx.com.gm.domain.Recompensas;

/**
 *
 * @author Alejandro Maguey
 */
public interface RecompensasService {
    
    public List<Recompensas> ListarRecompensas();
    public void guardar(Recompensas recompensa);
    public void eliminar(Recompensas recompensa);
    public Recompensas encontrarRecompensas(Recompensas recompensa);
    
}
