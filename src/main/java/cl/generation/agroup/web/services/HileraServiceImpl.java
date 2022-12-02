package cl.generation.agroup.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.generation.agroup.web.models.Hilera;
import cl.generation.agroup.web.repositories.HileraRepository;

@Service
public class HileraServiceImpl implements HileraService {

	@Autowired
	private HileraRepository hileraRepository;

	@Override
	public Hilera guardarHilera(Hilera hilera) {
		return hileraRepository.save(hilera);
	}

	@Override
	public String eliminarHilera(Long id) {
		Boolean existe = hileraRepository.existsById(id);
		if (existe) {
			hileraRepository.deleteById(id);
		} else {
			return "La hilera no existe";
		}
		return "Hilera eliminada";
	}

	@Override
	public String actualizarHilera(Hilera hilera) {
		Boolean existe = hileraRepository.existsById(hilera.getId());
		if (existe) {
			hileraRepository.save(hilera);
			return "Hilera actualizada";
		}
		return "Hilera no actualizada";
	}

	@Override
	public Hilera obtenerHilera(Long id) {
		return hileraRepository.findById(id).get();
	}

	@Override
	public List<Hilera> listaHilera() {
		return hileraRepository.findAll();
	}

}
