
package mx.com.gm.servicios;

import java.util.List;
import mx.com.gm.domain.Roles;

/**
 *
 * @author Alejandro Maguey
 */
public interface RolesService {
    
    public List<Roles> ListarRoles();
    public void guardar(Roles roles);
    public void eliminar(Roles roles);
    public Roles encontrarRoles(Roles roles);
    public List<Roles> encontrarNombreroles(Roles roles);
    
}
