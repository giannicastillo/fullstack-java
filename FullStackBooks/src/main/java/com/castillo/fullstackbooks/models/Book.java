package com.castillo.fullstackbooks.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name= "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message= "Invalid Credentials!")
	private String title;
	
	@NotEmpty(message= "Invalid Credentials!")
	private String authorName;
	
	@NotEmpty(message= "Invalid Credentials!")
	private String myThoughts;
	
	//MANY TO ONE RELATIONSHIP WITH USERS
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "user_id")
	private User user;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	//other getters and setters removed for brevity 
	
	 @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	    
	    //empty constructor 
	    public Book() {
	    }  
	    
	    //loaded constructor 
		public Book(String title, String authorName, String myThoughts, Book book) {
			
			this.title = title;
			this.authorName = authorName;
			this.myThoughts = myThoughts;
		}
		
		
		//GENERATE GETTERS AND SETTERS
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getAuthorName() {
			return authorName;
		}
		public void setAuthorName(String authorName) {
			this.authorName = authorName;
		}
		public String getMyThoughts() {
			return myThoughts;
		}
		public void setMyThoughts(String myThoughts) {
			this.myThoughts = myThoughts;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		
		
		
		
		
	    
	  
	    

}
