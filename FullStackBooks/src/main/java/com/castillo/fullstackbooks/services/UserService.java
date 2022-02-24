package com.castillo.fullstackbooks.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.castillo.fullstackbooks.models.LoginUser;
import com.castillo.fullstackbooks.models.User;
import com.castillo.fullstackbooks.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	//same thing as above
//	public UserService(UserRepository userRepo) {
//		this.userRepo = userRepo;
//	}
	
	// TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        // TO-DO: Additional validations!
		// TO-DO - Reject values or register if no errors:
		        
		        // Reject if email is taken (present in database)
    		Optional<User> potentialUser = this.userRepo.findByEmail(newUser.getEmail());//check if the email of the object coming from the registration form matches any users email in the db.  If the email matches, that means that email is taken! 
    		
    		System.out.println("We got this far");
		if(potentialUser.isPresent()) {
    		//this means email is taken b/c it found a user that matched the email from reg form
    			result.rejectValue("email", "EmailTaken","This email is taken, try again!");
		}
    	
		        // Reject if password doesn't match confirmation
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm","Email Taken","Password must match Confirm Password!");
			
		}
		        
		        // Return null if result has errors
		if(result.hasErrors()) {
			return null;
		}else {
			//if no errors after checking all the validations then you can create a user 
			//to create a user you must first secure a password using bcrypt and then save them to the db
		
			String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			
			//set the user object password to be the harsh password 
			newUser.setPassword(hashed);
			return this.userRepo.save(newUser);

		}

    }
    public User login(LoginUser newLoginObject, BindingResult result) {
    	
    		if(result.hasErrors()) {
    			return null;
    		}
        // TO-DO: Additional validations!
    		// Find user in the DB by email
    		Optional<User> potentialUser = this.userRepo.findByEmail(newLoginObject.getEmail());
        // Reject if NOT present
    		//if the email was not found, create a custom validation error message
    		if(potentialUser ==null) {
    			result.rejectValue("email", "Not Found","This email is not found!");
    			return null;
    		}
    		//get that user based on their email
    		User user = potentialUser.get();
    		//if password doesnt match
    		if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
    			result.rejectValue("password", "matches", "Invalid Password");
    		}
    		//any other errors
    		if(result.hasErrors()) {
    			return null;
    		} else {
    			return user;
    		}
    }
    
    //get one user by id
    public User findOneUser(Long id) {
    	return this.userRepo.findById(id).orElse(null);
    }

}
