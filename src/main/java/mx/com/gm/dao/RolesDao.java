

package mx.com.gm.dao;


import java.util.List;
import mx.com.gm.domain.Roles;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface RolesDao extends CrudRepository<Roles, Integer> {
    
    @Query("select u from roles u where u.id_usuario = ?1")
    List<Roles> findNombreByIdUsuario(Integer id_usuario);
}
