package cl.practica2.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController, cuando mi aplicacion sera rest
@Controller // para que mi applicacion tenga el super poder de controlador, que redirecciones.
			// controlador para aplicaciones web
			// controlador va a estar escuchando el protocolo http (get (browser), post (enviando formulario),
			//	)
public class HomeController {
	
	//solo el home, la raiz
	@GetMapping("/")
	public String inicio() {
		
		return "inicio";
	}

}
