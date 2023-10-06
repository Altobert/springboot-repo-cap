package cl.practica5.app.controller;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String salvar(Articulo articulo, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			
			for (ObjectError error : result.getAllErrors()) {
				System.out.println("ha ocurrido algo: "+error.getDefaultMessage());
			}
			
			return "redirect:/crear";
			
		}else {
			
			servicio.save(articulo);
			attributes.addFlashAttribute("msg", "Registro completado");
		}
						
		return "redirect:/listar";
		
	}
	
	//(api rest) - si se puede hacer un delete
	//get post en una app web
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id, RedirectAttributes attributes) {
		try {
			servicio.delete(id);
		} catch (ResponseStatusException ex) {
			// TODO: handle exception
			attributes.addFlashAttribute("result", ex.getMessage());
		}
		return "redirect/listar";
	}

}
