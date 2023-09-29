package cl.practica3.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cl.practica3.app.entities.Articulo;
import cl.practica3.app.services.IArticuloService;

@Controller
public class HomeController {

    @Autowired
    IArticuloService articuloService;

    @GetMapping("/")
    public String inicio(Model modelo){

        List<Articulo> listArticulos = articuloService.findAll();
        modelo.addAttribute("articulos", listArticulos);

        return "listArticulos";
    }
    
}
