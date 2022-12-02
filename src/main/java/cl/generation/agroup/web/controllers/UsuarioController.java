package cl.generation.agroup.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@RequestMapping("/")
	public String getUsuario() {
		System.out.println("Metodo de obtener usuario");
		return "index.jsp";
	}

}
