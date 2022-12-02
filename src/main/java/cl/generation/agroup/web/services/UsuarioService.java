package cl.generation.agroup.web.services;

import java.util.List;

import cl.generation.agroup.web.models.Usuario;

public interface UsuarioService {
	
	// Aquí definimos métodos
	
	public Usuario guardarUsuario(Usuario usuario);
	public String eliminarUsuario(Long id);
	public String actualizarUsuario(Usuario usuario);
	public Usuario obtenerUsuario(Long id);	
	public List<Usuario> obtenerListaUsuarios();

}
