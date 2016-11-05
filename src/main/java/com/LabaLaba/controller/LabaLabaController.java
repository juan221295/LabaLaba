package com.LabaLaba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/LabaLaba")
public class LabaLabaController {
//    @RequestMapping("/LabaLaba")
//    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
//        model.addAttribute("name", name);
//        return "hello";
//    }
	@RequestMapping("/")
	public String index(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
	    model.addAttribute("name", "index");
	    return "index";
	}
	@RequestMapping("/signIn")
	public String signIn(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
	    model.addAttribute("name", "login");
	    return "signIn";
	}
	@RequestMapping(value= "/kategori")
	public String kategori(Model model, @RequestParam(value="kategoriName", required=false, defaultValue="World") String kategoriName){
		model.addAttribute("kategoriName", kategoriName);
		return "kategori";
		
	}
	@RequestMapping("/infoProduk")
	public String infoProduk(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
	    model.addAttribute("name", "infoProduk");
	    return "infoProduk";
	}
	
}