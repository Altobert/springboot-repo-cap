package cl.practica5.app.controller;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cl.practica5.app.entities.Articulo;
import cl.practica5.app.service.IArticuloService;

@Controller
public class ArticuloController {
	
	@Autowired
	private IArticuloService servicio;
	
	@GetMapping("/listar")
	public String inicio(Model model) {
		
		List<Articulo> listArticulo = servicio.findAll();
		
		model.addAttribute(null, listArticulo);
		
		return "listArticuclo"; 
	}
	
	@GetMapping("/crear")
	public String irAGuardar() {
		
		return "formArticulo";
		
	}
		
	@PostMapping("save")
	public String salvar(Articulo articulo, BindingResult result) {
		
		if(result.hasErrors()) {
			
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("ha ocurrido algo: "+error.getDefaultMessage());
			}
			
			return "redirect:/crear";
			
		}else {
			
			servicio.save(articulo);
		}
						
		return "redirect:/listar";
		
	}

}
