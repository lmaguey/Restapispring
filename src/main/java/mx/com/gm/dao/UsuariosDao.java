

package mx.com.gm.dao;



//import mx.com.gm.domain.Puntos;
import mx.com.gm.domain.Usuarios;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface UsuariosDao extends CrudRepository<Usuarios, Integer> {
    
    @Query("select u from usuarios u where u.nombre = ?1")
    Usuarios findUserByNombre(String nombre);
}
