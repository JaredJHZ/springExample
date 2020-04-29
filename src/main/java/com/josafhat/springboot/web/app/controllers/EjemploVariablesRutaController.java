package com.josafhat.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index(Model model){
		
		return "variables/index";
	}
	
	@GetMapping("/string/{texto}")
	public String variables(@PathVariable String texto, Model model){
		model.addAttribute("texto", texto);
		
		return "variables/ver";
	}
	
	@GetMapping("/string/{texto}/{numero}")
	public String variables(@PathVariable String texto, @PathVariable int numero, Model model) {
		model.addAttribute("texto", "El texto es "+texto+" y el numero es "+numero);
		
		return "variables/ver";
	}
	
	@ModelAttribute("titulo")
	public String titulo() {
		return "Recibir parametros a traves de la ruta";
	}

}
