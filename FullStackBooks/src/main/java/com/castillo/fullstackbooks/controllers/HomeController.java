package com.castillo.fullstackbooks.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.castillo.fullstackbooks.models.Book;
import com.castillo.fullstackbooks.models.LoginUser;
import com.castillo.fullstackbooks.models.User;
import com.castillo.fullstackbooks.services.BookService;
import com.castillo.fullstackbooks.services.UserService;

@Controller
public class HomeController {
	// Add once service is implemented:
     @Autowired
     private UserService userServ;
     
     @Autowired
     private BookService bookServ;
    
    @GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
//        
//        // TO-DO Later -- call a register method in the service
    	User user = this.userServ.register(newUser,result);//pass in the user obj from the form and the error messages (result variable) to the service to do additional logic for registration (compare password with confirm password, make sure email is not duplicate, and encrypt the password if the form is valid)
    	
    	//to do some extra validations and create a new user! 
//        // to do some extra validations and create a new user!
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page so the login form still has an object to bind to 
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
	
       
//        
//        // No errors! 
//        // TO-DO Later: Store their ID from the DB in session, 
//        // in other words, log them in.
        session.setAttribute("loggedInUserID", user.getId());
     
//    
        return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        // Add once service is implemented:
         User user = userServ.login(newLogin, result); //the variable user will be a user object if the validations are all good and password is correct. The User variable will be null if there are errors. 
         System.out.println(result);
        if(result.hasErrors()) {
        		System.out.println("we have errors");
            model.addAttribute("newUser", new User()); //the reg form still needs an empty object to bind if we have errors and we re-render the log reg page
            return "index.jsp";
        }
    
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        session.setAttribute("loggedInUserID", user.getId());
        // in other words, log them in.
        System.out.println(user.getId());
        return "redirect:/home";
   
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
    	Long id = (Long) session.getAttribute("loggedInUserID"); //this gives the ID of the user stored in session (logged in user's id)
    	
    	System.out.println("id of logged in user" + id);
    	
    	if(id == null) {//if they are not logged in and trying to view the dashboard, redirect to the login reg form
    		return "redirect:/";
    	}
    	
    	//get the user object with the ID from session using the service 
    	User loggedInUser = this.userServ.findOneUser(id);
    	
    	model.addAttribute("loggedInUser", loggedInUser);
    	
    	//get all the books from the service
    	List<Book> allBooks = this.bookServ.getAllBooks();
    	
    	//pass the list of all ideas to the template using the view model
    	model.addAttribute("allBooks", allBooks);
    	
    	return "dashboard.jsp";
    }
    
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate(); //clear out the session so it doesnt store the user as logged in anymore. 
    	
    	return "redirect:/";
    }
   
    
   
}

