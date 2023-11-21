

package mx.com.gm.servicios;

import java.util.List;
import mx.com.gm.dao.PuntosDao;
import mx.com.gm.dao.UsuariosDao;
import mx.com.gm.domain.Puntos;
import mx.com.gm.domain.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private UsuariosDao usuarioDao;
    
    @Autowired
    private PuntosDao puntosDao;
    
 
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> ListarUsuarios() {
        
        return (List<Usuarios>) usuarioDao.findAll();
        
    }

    @Override
    @Transactional
    public void guardar(Usuarios usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(Usuarios usuario) {
        usuarioDao.delete(usuario);
      
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuarios encontrarUsuario(Usuarios usuario) {
      
    return usuarioDao.findById(usuario.getId()).orElse(null);
}

    @Override
    @Transactional(readOnly = true)
    public Usuarios encontrarIdUsuario(Usuarios usuario) {
       return usuarioDao.findUserByNombre(usuario.getNombre());
    }
    
   

    }