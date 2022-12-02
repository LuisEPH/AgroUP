package cl.generation.agroup.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.generation.agroup.web.models.Categoria;
import cl.generation.agroup.web.services.CategoriaServiceImpl;

@RestController
public class CategoriaApiRestController {

	@Autowired
	private CategoriaServiceImpl categoriaServiceImpl;
	
	@RequestMapping("/guardar/categoria")
	public Categoria guardarCategoria(@RequestBody Categoria categoria) {
		return categoriaServiceImpl.guardarCategoria(categoria);
	}
	
	@RequestMapping("/eliminar/categoria")
	public String eliminarCategoria(@RequestParam(value = "id", required = true) Long id) {
		return categoriaServiceImpl.eliminarCategoria(id);
	}
	
	@RequestMapping("/actualizar/categoria")
	public String actualizarCategoria(@RequestBody Categoria categoria) {
		if(categoria.getId()!=null) {
			return categoriaServiceImpl.actualizarCategoria(categoria);
		}
		return "No se actualizó la categoria";
	}
	
	@RequestMapping("/obtener/categoria")
	public Categoria obtenerCategoria(@RequestParam(value = "id", required = true) Long id) {
		return categoriaServiceImpl.obtenerCategoria(id);
	}
	
	@RequestMapping("/listar/categorias")
	public List<Categoria> listaCategoria(){
		return categoriaServiceImpl.listaCategoria();
	}
}

