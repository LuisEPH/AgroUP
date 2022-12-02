package cl.generation.agroup.web.services;

import java.util.List;

import cl.generation.agroup.web.models.Terreno;


public interface TerrenoService {
	
	public Terreno guardarTerreno(Terreno terreno);
	public String eliminarTerreno(Long id);
	public Terreno obtenerTerreno(Long id);	
	public String actualizarTerreno(Terreno terreno);
	public List<Terreno> obtenerListaTerrenos();

}
