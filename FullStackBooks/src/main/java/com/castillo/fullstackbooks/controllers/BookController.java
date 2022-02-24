package com.castillo.fullstackbooks.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.castillo.fullstackbooks.models.Book;
import com.castillo.fullstackbooks.services.BookService;

@Controller
public class BookController {
	
	@Autowired
    private BookService bookServ;
	
	 @RequestMapping("/books/new")
	    public String newBookPage(Model model, HttpSession session) {
	    	//we will render a create form in this method
	    	
	    	
	    	//pass in empty book object to the form can bind to it. 
	    	model.addAttribute("book", new Book());
	    	
	    	//pass info about the logged in user to the form so that we know who is the user of the book. 
	    	//loggedInUserID
	    	//get the id of the logged in user to the form so that we know who is the user of the book. 
	    	Long idOfLoggedInUser =(Long)session.getAttribute("loggedInUserID");
	    	
	    	model.addAttribute("idOfLoggedInUser", idOfLoggedInUser);
	    	
	    	return "create.jsp";
	    	
	    	
	    }
	 
	 @PostMapping("/books/create")
	 public String createNewBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		 if(result.hasErrors()) {
			 System.out.println("testing!");
			 return "create.jsp";
		 }
		 //if the form is submitted properly and there are no validation errors, request the service to create something new(new idea). 
		 this.bookServ.createNewBook(book);
		 
		 return "redirect:/home";
	 }
	 //get request for showing one pager
	 
	 @RequestMapping("/books/{id}/details")
	 public String getBookDetails(@PathVariable("id") Long id, Model model) {
		 
		 //use the id from the path variable to send to the service to get info about a book given that id.
		 Book bookToShow = this.bookServ.getOneBook(id);
		 
		 model.addAttribute("bookToShow", bookToShow);
		 
		 return "details.jsp";
		 
	 }
	 
	 @RequestMapping("/books/{id}/edit")
	 public String editBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		 
		 //get a book from the DB using the service and the id from the path 
		 Book book = this.bookServ.getOneBook(id);
		 
		 model.addAttribute("book", book);
		 
		//get the id of the logged in user to the form so that we know who is the user of the book. 
	    	Long idOfLoggedInUser =(Long)session.getAttribute("loggedInUserID");
	    	
	    	//pass info about the logged in user to the form so that we know who is the user of the book. 	
	    	model.addAttribute("idOfLoggedInUser", idOfLoggedInUser);
	    	
	    	//check only render the jsp if the id of the loggedin user is the same as the id of the idea creator
	    	if(idOfLoggedInUser == book.getUser().getId()) {
	    		return "edit.jsp";
	 		}else {
	 			return "redirect:/home";
	 }
	 }
	 
	 @PutMapping("/books/{id}/update")
	 public String updateBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
		 
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		
		//if no validation errors, send the book object from the form to the service so the service can update it
		this.bookServ.updateBook(book);
		return "redirect:/home";
		
	 }
	 
	 @RequestMapping("/books/{id}/delete")
	 public String deleteBook(@PathVariable("id") Long id) {
		 this.bookServ.deleteBook(id);
		 return "redirect:/home";
	 }
	 
	 
	

}
