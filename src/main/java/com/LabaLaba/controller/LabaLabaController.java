package com.LabaLaba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LabaLabaController {

	@RequestMapping("/")
	public String index(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
	    model.addAttribute("name", "index");
	    return "index";
	}

	
}