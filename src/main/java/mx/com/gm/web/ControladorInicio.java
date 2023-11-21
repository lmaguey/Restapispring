

package mx.com.gm.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.metamodel.SingularAttribute;
import java.io.Serializable;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Puntos;
import mx.com.gm.domain.Recompensas;
import mx.com.gm.domain.Roles;
import mx.com.gm.domain.Usuarios;
import mx.com.gm.servicios.PuntosService;
import mx.com.gm.servicios.RecompensasService;
import mx.com.gm.servicios.RolesService;
import mx.com.gm.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alejandro Maguey
 */

//@RestController
@RestController
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private PuntosService puntosService;
    
    @Autowired
    private RecompensasService recompensasService;
    
    @Autowired
    private RolesService rolesService;
    
    @GetMapping("/usuarios")
      public List<Usuarios> inicio(Model model) { 
          var usuarios = usuarioService.ListarUsuarios();
         log.info("Se esta ejecutando el control rest");
         log.debug("más detalle del controlador");
          model.addAttribute("usuarios",usuarios);
          //return "index";
          return usuarios;
      }
      
      @GetMapping("/puntos")
      public List<Puntos> iniciopuntos(Model model) { 
          var puntos = puntosService.ListarPuntos();
         log.info("Se esta ejecutando el control rest");
         log.debug("más detalle del controlador");
          model.addAttribute("puntos",puntos);
          //return "index";
          return puntos;
      }
      
      
      @GetMapping("/recompensas")
      public List<Recompensas> iniciorecompensas(Model model) { 
          var recompensas = recompensasService.ListarRecompensas();
         log.info("Se esta ejecutando el control rest");
         log.debug("más detalle del controlador");
          model.addAttribute("puntos",recompensas);
          //return "index";
          return recompensas;
      }
      
      
      @GetMapping("/roles")
      public List<Roles> inicioroles(Model model) { 
          var roles = rolesService.ListarRoles();
         log.info("Se esta ejecutando el control rest");
         log.debug("más detalle del controlador");
          model.addAttribute("roles",roles);
          //return "index";
          return roles;
      }
      
      
      @PutMapping("/usuarios/actualizar")
      public void agregar(@RequestBody String usuarioJson) throws JsonProcessingException {
          ObjectMapper mapper = new ObjectMapper();
          var usuario = mapper.readValue(usuarioJson, Usuarios.class);
          usuarioService.guardar(usuario);
      }
      
      
      @PutMapping("/puntos/actualizar")
      public void agregarpuntos(@RequestBody String puntosJson) throws JsonProcessingException {
          ObjectMapper mapper = new ObjectMapper();
          var puntos = mapper.readValue(puntosJson, Puntos.class);
          puntosService.guardar(puntos);
      }
      
      
      @PutMapping("/recompensas/actualizar")
      public void agregarrecompensas(@RequestBody String recompensasJson) throws JsonProcessingException {
          ObjectMapper mapper = new ObjectMapper();
          var recompensas = mapper.readValue(recompensasJson, Recompensas.class);
          recompensasService.guardar(recompensas);
      }
      
      
      @PostMapping("/usuarios/guardar")
       public void guardar(@RequestBody String usuarioJson) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();   
        var usuario = mapper.readValue(usuarioJson, Usuarios.class);
        log.info("Se esta enviando el siguiente usuario " + usuario);
        usuarioService.guardar(usuario);
         //  return "redirect:/";
       }
       
       @PostMapping("/puntos/guardar")
       public void guardarpuntos(@RequestBody String puntosJson) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();   
        var puntos = mapper.readValue(puntosJson, Puntos.class);
        log.info("Se esta enviando el siguiente usuario " + puntos);
        puntosService.guardar(puntos);
         //  return "redirect:/";
       }
       
       
       @PostMapping("/recompensas/guardar")
       public void guardarrecompensas(@RequestBody String recompensasJson) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();   
        var recompensas = mapper.readValue(recompensasJson, Recompensas.class);
        log.info("Se esta enviando el siguiente usuario " + recompensas);
        recompensasService.guardar(recompensas);
         //  return "redirect:/";
       }
       
       
       @PostMapping("/roles/guardar")
       public void guardarroles(@RequestBody String rolesJson) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();   
        var roles = mapper.readValue(rolesJson, Roles.class);
        log.info("Se esta enviando el siguiente usuario " + roles);
        rolesService.guardar(roles);
         //  return "redirect:/";
       }
       
       
    
       @GetMapping("/usuarios/editar/{id}")
       public Usuarios editar(Usuarios usuario, Model model){
         usuario = usuarioService.encontrarUsuario(usuario); 
         model.addAttribute(usuario);
         return usuario;
       }
       
       @GetMapping("/puntos/editar/{id}")
       public Puntos editar(Puntos puntos, Model model){
         puntos = puntosService.encontrarUsuario(puntos); 
         model.addAttribute(puntos);
         return puntos;
       }
       
       @GetMapping("/recompensas/editar/{id}")
       public Recompensas editar(Recompensas recompensas, Model model){
          recompensas = recompensasService.encontrarRecompensas(recompensas); 
         model.addAttribute(recompensas);
         return recompensas;
      
       }
       
       @GetMapping("/usuarios/id/{nombre}")
       public Usuarios editarid(Usuarios usuario, Model model){
           usuario = usuarioService.encontrarIdUsuario(usuario);
           model.addAttribute(usuario);
           return usuario;
       }
       
       
       @GetMapping("/usuarios/puntos/{id_usuario}")
       public Puntos editarpuntos(Puntos puntos, Model model){
         puntos = puntosService.encontrarPuntos(puntos); 

         model.addAttribute(puntos);
         return puntos;
       }
       
       
       @GetMapping("/roles/nombres/{id_usuario}")
       public List<Roles> editarpuntos(Roles roles, Model model){
         var rol = rolesService.encontrarNombreroles(roles); 

         model.addAttribute(rol);
         return rol;
       }
       
      
       @GetMapping("/usuarios/eliminar/{id}")
       public void eliminar(Usuarios usuario){
         usuarioService.eliminar(usuario);
         //return "redirect:/";
       }
       
       
       @GetMapping("/puntos/eliminar/{id}")
       public void eliminarpuntos(Puntos puntos){
         puntosService.eliminar(puntos);
         //return "redirect:/";
       }
    
       
       @GetMapping("/recompensas/eliminar/{id}")
       public void eliminarrecompensas(Recompensas recompensas){
         recompensasService.eliminar(recompensas);
         //return "redirect:/";
       }
    
    
}
