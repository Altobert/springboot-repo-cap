package com.netec.app.controller;

import java.util.List;

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

import com.netec.app.entities.Articulo;
import com.netec.app.service.IArticuloService;

@Controller
public class ArticuloController {
	
	@Autowired
	private IArticuloService servicio;
	
	
	@GetMapping("/listar")
	public String inicio(Model model) {
		
		List<Articulo> datos=servicio.findAll();
		model.addAttribute("articulos", datos);
		
		return "listArticulo";
	}
	
	
	@GetMapping("/crear")
	public String add() {
		
		return "formArticulo";
		
	}
	
	
	@PostMapping("/save")
	public String salvar(Articulo art, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			
			for(ObjectError error: result.getAllErrors()) {
				System.out.println("Ocurrio algo: "+error.getDefaultMessage());
			}
			
			return "formArticulo";
			
		}
		
		Articulo art2 = servicio.save(art);
		attributes.addFlashAttribute("msg","Registro completado");
		return "redirect:/listar";
	}

	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id, RedirectAttributes attributes) {
		
		try {
			
			servicio.delete(id);
			attributes.addFlashAttribute("result","Borrado Exitoso");
			
		}catch(ResponseStatusException ex) {
			
		    attributes.addFlashAttribute("result",ex.getMessage());
		    
		}
		
		return "redirect:/listar";	
	}
	
	
	@GetMapping ("/update/{id}")
	public String actualizar(@PathVariable("id") int id ,Model model) {
		
		Articulo art= servicio.findById(id);
		model.addAttribute("objeto", art);
		
		return "formArticulo";
	}

	
	
}

