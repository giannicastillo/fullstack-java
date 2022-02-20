package com.castillo.crudsafetravels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.castillo.crudsafetravels.models.TravelItem;
import com.castillo.crudsafetravels.service.TravelItemService;

@RestController
public class TravelItemAPI {
	private final TravelItemService travelService;
	
	public TravelItemAPI(TravelItemService travelService) {
		this.travelService = travelService;
	}
	
	@RequestMapping("/api/travelitems")
	public List<TravelItem> index(){
		return this.travelService.allTravelItems();
	}
	
	@PostMapping("/api/travelitems")
	public TravelItem create(
			@RequestParam("expense") String expense, 
			@RequestParam ("vendor") String vendor, 
			@RequestParam("amount") double amount, 
			@RequestParam("description") String description
			) {
		
		//create an instance of travelItem with info from the form 
		TravelItem newItem = new TravelItem(expense,vendor,amount,description);
		
		return this.travelService.createTravelItem(newItem);
		
	}
	
	 @RequestMapping("/api/travelitems/{id}")
	    public TravelItem show(@PathVariable("id") Long id) {
	        TravelItem travelItemToShow = this.travelService.findTravelItem(id);
	        
	        return travelItemToShow;
	    }
//    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
//        Book book = new Book(title, desc, lang, numOfPages);
//        return bookService.createBook(book);
//    }

}
