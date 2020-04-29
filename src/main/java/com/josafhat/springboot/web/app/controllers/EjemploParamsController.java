package com.josafhat.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	
	@GetMapping("/")
	public String index(Model model) {
		return "params/index";
	}
	
	
	
	@GetMapping("/string")
	public String param(@RequestParam(name="texto", required=false, defaultValue="xd") String texto , Model model) {
		model.addAttribute("texto", texto);
		return "params/ver";
	}
	
	@GetMapping("/mix-params")
	public String param(@RequestParam String texto, @RequestParam int numero, Model model) {
		
		model.addAttribute("texto", "El numero es: "+numero+" y el texto es: "+texto);
		return "params/ver";
	}
	
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		
		String texto = request.getParameter("texto");
		int numero = 0;
		
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		}catch(NumberFormatException e) {
			numero = 0;
		}finally {
			model.addAttribute("texto", "El numero es: "+numero+" y el texto es: "+texto);
		}
		
		return "params/ver";
	}
	
}
