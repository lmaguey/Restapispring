

package mx.com.gm.servicios;

import java.util.List;
import mx.com.gm.dao.PuntosDao;
import mx.com.gm.domain.Puntos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PuntosServiceImpl implements PuntosService {
    
    @Autowired
    private PuntosDao puntosDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Puntos> ListarPuntos() {
        
        return (List<Puntos>) puntosDao.findAll();
        
    }

    @Override
    @Transactional
    public void guardar(Puntos puntos) {
        puntosDao.save(puntos);
    }

    @Override
    @Transactional
    public void eliminar(Puntos puntos) {
        puntosDao.delete(puntos);
      
    }
    
    @Override
    @Transactional(readOnly = true)
    public Puntos encontrarUsuario(Puntos puntos) {
  
        return puntosDao.findById(puntos.getId()).orElse(null);
}
    
    @Override
    @Transactional(readOnly = true)
    public Puntos encontrarPuntos(Puntos puntos) {
      return puntosDao.findUserByIdUsuario(puntos.getId_usuario());
    }

    }