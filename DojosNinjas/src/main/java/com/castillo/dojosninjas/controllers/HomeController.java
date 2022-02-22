package com.castillo.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.castillo.dojosninjas.models.Dojo;
import com.castillo.dojosninjas.models.Ninja;
import com.castillo.dojosninjas.services.AppService;

@Controller
public class HomeController {
	private final AppService appServ;
	
	public HomeController(AppService appServ) {
		this.appServ = appServ;
	}
	
	@RequestMapping("/")
	public String home(Model model) {
		
		//whenever you want to render a form, send the empty object to a form using 
		//the view model so that the form can bind to the empty object 
		//and have it validations and it can update objects info 
		//from the form.
		model.addAttribute("dojo", new Dojo());
		
		return "dojohome.jsp";
	}
	
	@PostMapping("/dojo/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "dojohome.jsp";
		}else {
			//if no form errors, create a team by using the service 
			this.appServ.createDojo(dojo);
			return "redirect:/";
		}
		
	}
	
	@RequestMapping("/ninjas/add")
	public String addNinja(Model model) {
		//pass an empty ninja obj to the form for the form to bind to and update its information with.
		model.addAttribute("ninja", new Ninja ());
		
		//pass a list of all dojos to the template so that the form can show all the teams that the ninja can be added 
		model.addAttribute("alldojos", this.appServ.getAllDojos());
		
		return "ninjahome.jsp";
	}
	
	//create a ninja when the form submits using post request
	@PostMapping("/ninjas/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result)
	{
		if(result.hasErrors()) {
			return "ninjahome.jsp";
		}else {
			//if no errors in form, then create a player using the service. 
			this.appServ.createNinja(ninja);
			return "redirect:/";
		}
		
	}
	
	@RequestMapping("/dojos/{id}")
	public String showOneDojoDetails(@PathVariable("id")Long id, Model model){
		//get one dojo using the ID from the path variable by requesting it from the service 
		Dojo dojoToShow = this.appServ.getOneDojo(id);
		
		model.addAttribute("dojoToShow", dojoToShow);
		
		return "oneDojoDetails.jsp";
		
	}
	
	

}
