package cl.generation.agroup.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.generation.agroup.web.models.Hilera;
import cl.generation.agroup.web.services.HileraServiceImpl;

@RestController
public class HileraApiRestController {
	
	@Autowired
	private HileraServiceImpl hileraServiceImpl;
	
	@RequestMapping("/guardar/hilera")
	public Hilera guardarHilera(@RequestBody Hilera hilera) {
		return hileraServiceImpl.guardarHilera(hilera);
	}
	
	@RequestMapping("/eliminar/hilera")
	public String eliminarHilera(@RequestParam(value = "id", required = true) Long id) {
		return hileraServiceImpl.eliminarHilera(id);
	}
	
	@RequestMapping("/actualizar/hilera")
	public String actualizarHilera(@RequestBody Hilera hilera) {
		if(hilera.getId()!=null) {
			return hileraServiceImpl.actualizarHilera(hilera);
		}
		return "No se actualizó la hilera";
	}
	
	@RequestMapping("/obtener/hilera")
	public Hilera obtenerHilera(@RequestParam(value = "id", required = true) Long id) {
		return hileraServiceImpl.obtenerHilera(id);
	}
	
	@RequestMapping("/listar/hileras")
	public List<Hilera> listaCategoria(){
		return hileraServiceImpl.listaHilera();
	}
}
