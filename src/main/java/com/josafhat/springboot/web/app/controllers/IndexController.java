package com.josafhat.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.josafhat.springboot.web.app.models.Usuario;;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoTitulo;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String listarTitulo;

	@RequestMapping(value= {"/index","/","home"}, method = RequestMethod.GET)
	public String index(Model model){
		model.addAttribute("titulo", textoTitulo);
		
		return "index";
	}
	
	@RequestMapping(value = {"/perfil"}, method = RequestMethod.GET)
	public String perfil(Model model) {
		
		var usuario = new Usuario();
		usuario.setNombre("Jared");
		usuario.setApellido("Zuñiga");
		usuario.setEmail("jaredhz2597@gmail.com");
		model.addAttribute("usuario",  usuario);
		model.addAttribute("titulo", "Perfil del usuario ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	@GetMapping("/listar")
	public String listar(Model model){
		model.addAttribute("titulo", listarTitulo);
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		return Arrays.asList(
				new Usuario("Jared", "zuñiga", "jaredjhz2597@gmail.com"),
				new Usuario("Guadalupe", "Isabel", "guadIsa@gmail.com"),
				new Usuario("Victor", "Hugo", "victor@gmail.com")
		);
	}
 	
	
 }
