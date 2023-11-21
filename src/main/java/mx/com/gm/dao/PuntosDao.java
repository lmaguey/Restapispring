

package mx.com.gm.dao;

import mx.com.gm.domain.Puntos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface PuntosDao extends CrudRepository<Puntos, Integer> {
    
    @Query("select u from puntos u where u.id_usuario = ?1")
    Puntos findUserByIdUsuario(Integer id_usuario);
}
