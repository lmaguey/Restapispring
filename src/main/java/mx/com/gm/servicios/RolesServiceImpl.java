

package mx.com.gm.servicios;

import java.util.List;
import mx.com.gm.dao.RolesDao;
import mx.com.gm.domain.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RolesServiceImpl implements RolesService {
    
    @Autowired
    private RolesDao rolesDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Roles> ListarRoles() {
        
        return (List<Roles>) rolesDao.findAll();
        
    }

    @Override
    @Transactional
    public void guardar(Roles roles) {
        rolesDao.save(roles);
    }

    @Override
    @Transactional
    public void eliminar(Roles roles) {
        rolesDao.delete(roles);
      
    }
    
    @Override
    @Transactional(readOnly = true)
    public Roles encontrarRoles(Roles roles) {
  
        return rolesDao.findById(roles.getId()).orElse(null);
}
    
    @Override
    @Transactional(readOnly = true)
    public List<Roles> encontrarNombreroles(Roles roles) {
      return (List<Roles>) rolesDao.findNombreByIdUsuario(roles.getId_usuario());
    }

    }