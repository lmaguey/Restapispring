

package mx.com.gm.servicios;

import java.util.List;
import mx.com.gm.dao.RecompensasDao;
import mx.com.gm.domain.Recompensas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecompensasServiceImpl implements RecompensasService {
    
    @Autowired
    private RecompensasDao recompensasDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Recompensas> ListarRecompensas() {
        
        return (List<Recompensas>) recompensasDao.findAll();
        
    }

    @Override
    @Transactional
    public void guardar(Recompensas recompensas) {
        recompensasDao.save(recompensas);
    }

    @Override
    @Transactional
    public void eliminar(Recompensas recompensas) {
        recompensasDao.delete(recompensas);
      
    }
    
    @Override
    @Transactional(readOnly = true)
    public Recompensas encontrarRecompensas(Recompensas recompensas) {
      
    return recompensasDao.findById(recompensas.getId()).orElse(null);
}

    }