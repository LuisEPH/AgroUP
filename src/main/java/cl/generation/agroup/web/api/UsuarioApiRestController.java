package cl.generation.agroup.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.generation.agroup.web.models.Usuario;
import cl.generation.agroup.web.services.UsuarioServiceImpl;


@RestController
public class UsuarioApiRestController {
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	@RequestMapping("/guardar/usuario")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		 /*
		 * {
		 * nombre:"Mijail",
		 * correo:"a@a.cl",
		 * password: "secret"
		 * }
		 * */
		
		return usuarioServiceImpl.guardarUsuario(usuario);
	}
	
	@RequestMapping("/eliminar/usuario")
	public String eliminarUsuario(@RequestParam(value = "id", required = false) Long id){
		// Aqui llamamos al metodo eliminar en el servicio
		return usuarioServiceImpl.eliminarUsuario(id);
	}
	
	@RequestMapping("/actualizar/usuario")
	public String actualizarUsuario(@RequestBody Usuario usuario) {
		if (usuario.getId()!=null) {
			String mensaje = usuarioServiceImpl.actualizarUsuario(usuario);
			return mensaje;
		}
		return "No se actualizará ningun usuario";
	}
	
	@RequestMapping("/obtener/usuario")
	public Usuario obtenerUsuario(@RequestParam(value="id",required = true) Long id){
		
		return usuarioServiceImpl.obtenerUsuario(id);
				
	}
	
	// AHora vamos a listar a todos los usuarios
	@GetMapping("listar/usuarios")
	public List<Usuario> obtenerListaUsuarios(){
		return usuarioServiceImpl.obtenerListaUsuarios();
	}

}

