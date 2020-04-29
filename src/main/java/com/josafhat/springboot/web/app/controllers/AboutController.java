package com.josafhat.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutController {
	
	@GetMapping("/about")
	public ModelAndView about() {
		var modelView = new ModelAndView();
		modelView.addObject("message", "hola prros");
		modelView.setViewName("about");
		return modelView;
	}

}
