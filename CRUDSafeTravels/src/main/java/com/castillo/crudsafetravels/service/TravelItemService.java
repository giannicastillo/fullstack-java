package com.castillo.crudsafetravels.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.castillo.crudsafetravels.models.TravelItem;
import com.castillo.crudsafetravels.repositories.TravelItemRepository;

@Service
public class TravelItemService {
    // adding the book repository as a dependency
    private final TravelItemRepository travelRepo;
    
    //constructor that has the repository injected into it (dependency injection)
    //initializes the Service with connection to the repository
    public TravelItemService(TravelItemRepository travelRepo) {
        this.travelRepo = travelRepo;
    }
    
    //methods that can use the repository to talk to the BD
    //returns all the travel items 
    
    public List<TravelItem> allTravelItems() {
    	 return (List<TravelItem>)this.travelRepo.findAll();
    }
    
 // creates a book
    public TravelItem createTravelItem(TravelItem travelItem) {
        return this.travelRepo.save(travelItem);
    }
    
 // retrieves a book
//    public Book findBook(Long id) {
//        Optional<Book> optionalBook = bookRepository.findById(id);
//        if(optionalBook.isPresent()) {
//            return optionalBook.get();
//        } else {
//            return null;
//        }
    
    //retrieves a TravelItem by id
    public TravelItem findTravelItem(Long id) {
    	return this.travelRepo.findById(id).orElse(null);
    }
    
    //update a minimum given an object 
    public TravelItem updateItem(TravelItem travelItem) {
    	return this.travelRepo.save(travelItem);
    }
    
    //delete travelitem by its ID
    public void deleteItem(Long id) {
    	this.travelRepo.deleteById(id);
    }
    
}
