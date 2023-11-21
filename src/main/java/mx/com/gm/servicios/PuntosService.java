
package mx.com.gm.servicios;

import java.util.List;
import mx.com.gm.domain.Puntos;

/**
 *
 * @author Alejandro Maguey
 */
public interface PuntosService {
    
    public List<Puntos> ListarPuntos();
    public void guardar(Puntos usuario);
    public void eliminar(Puntos usuario);
    public Puntos encontrarUsuario(Puntos puntos);
    public Puntos encontrarPuntos(Puntos puntos);
    
}
