
package mx.com.gm.servicios;

import java.util.List;
//import mx.com.gm.domain.Puntos;
import mx.com.gm.domain.Usuarios;

/**
 *
 * @author Alejandro Maguey
 */
public interface UsuarioService {
    
    public List<Usuarios> ListarUsuarios();
    public void guardar(Usuarios usuario);
    public void eliminar(Usuarios usuario);
    public Usuarios encontrarUsuario(Usuarios usuario);
    public Usuarios encontrarIdUsuario(Usuarios usuario);
    
}
