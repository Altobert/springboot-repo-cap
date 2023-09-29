package cl.practica2.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cl.practica2.app.entities.Alumno;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String inicio(Model modelo) {
		//crear alumno 
		//llevar a alumno a la pagina web		
		Alumno alumno = new Alumno("Alberto", 43, "27/09/1980", "Informatico", "soy un bacan");
		
		modelo.addAttribute("alum", alumno);
		
		return "inicio";
	}

}
