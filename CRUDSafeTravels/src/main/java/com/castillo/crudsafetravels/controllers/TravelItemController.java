package com.castillo.crudsafetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.castillo.crudsafetravels.models.TravelItem;
import com.castillo.crudsafetravels.service.TravelItemService;

@Controller
public class TravelItemController {
private final TravelItemService travelService;
	


	public TravelItemController(TravelItemService travelService) {
		this.travelService = travelService;
	}
	
	@RequestMapping("/travelitems")
	public String index(Model model){
		
		System.out.println(this.travelService.allTravelItems());
		
		List<TravelItem> allTravelItems = this.travelService.allTravelItems();
		
		model.addAttribute("allTravelItems", allTravelItems);
				
		//send an empty menu item to the form for the form to bind to
		model.addAttribute("travelItem", new TravelItem());
		return "index.jsp";
	}
	
	//get info about one travel item by its id
	@RequestMapping("/travelitems/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
		
		//retrieve menu items and put in variable 
        TravelItem travelItemToShow = this.travelService.findTravelItem(id);
        
        model.addAttribute("travelItem", travelItemToShow);
        return "oneitem.jsp";
    }
	
	//create a travelitem post submission of the form 
	@PostMapping("/travelitems/create")
	public String create(@Valid @ModelAttribute("travelItem") TravelItem travelItem, 
			BindingResult result, Model model)
			 {
		if(result.hasErrors()) {
			//need to pass in all travel items again
			List<TravelItem> allTravelItems = this.travelService.allTravelItems();
			
			//head to pass in all travel items again
			model.addAttribute("allTravelItems", allTravelItems);
			return "index.jsp";
		}else {
			this.travelService.createTravelItem(travelItem);
			return "redirect:/travelitems";
		}
	}
		
	@RequestMapping("/travelitems/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		//get info about the travel item I want to edit using the ID in the path route. I want to edit so I can pre-populate the edit form with this travel item's info.  
		
		TravelItem itemToEdit = this.travelService.findTravelItem(id);
		
		model.addAttribute("itemToEdit", itemToEdit);
		
		return "edit.jsp";
			
	}
	
	@PutMapping("/travelitems/update/{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("itemToEdit") TravelItem itemToEdit, BindingResult result, Model model) 
	{
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			this.travelService.updateItem(itemToEdit);
			return "redirect:/travelitems";
			
		}
		
	}
	
	@RequestMapping("/travelitems/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.travelService.deleteItem(id);
		
		return "redirect:/travelitems";
		
	}


}
