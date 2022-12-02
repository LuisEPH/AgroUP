package cl.generation.agroup.web.api;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.generation.agroup.web.models.Terreno;
import cl.generation.agroup.web.services.TerrenoServicesImpl;


@RestController
public class TerrenoApiRestController {
	@Autowired
	private TerrenoServicesImpl terrenoServiceImpl;
	
	// Guardar Terreno
	@RequestMapping("/guardar/terreno")
	public Terreno guardarTerreno(@RequestBody Terreno terreno) {
		 /*
		 * {
		 * nombre:"Mijail",
		 * correo:"a@a.cl",
		 * password: "secret"
		 * 
		 * */
		return terrenoServiceImpl.guardarTerreno(terreno);
	}
	// Eliminar Terreno
	@RequestMapping("/eliminar/terreno")
	public String eliminarTerreno(@RequestParam(value = "id", required = false) Long id){
		// Aqui llamamos al metodo eliminar en el servicio
		return terrenoServiceImpl.eliminarTerreno(id);
	}
	// Actualizar Terrenos
	@RequestMapping("/actualizar/terreno")
	public String actualizarTerreno(@RequestBody Terreno terreno) {
		if (terreno.getId()!=null) {
			String mensaje = terrenoServiceImpl.actualizarTerreno(terreno);
			return mensaje;
		}
		return "No se encontró el terreno";
	}
	// Obtener Terreno
	@RequestMapping("/obtener/terreno")
	public Terreno obtenerTerreno(@RequestParam(value="id",required = true) Long id){
		
		return terrenoServiceImpl.obtenerTerreno(id);			
	}
	
	// Listar todos los terrenos.

	@GetMapping("listar/terrenos")
	public List<Terreno> obtenerListaTerrenos(){
		return terrenoServiceImpl.obtenerListaTerrenos();
	}

}
