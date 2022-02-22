package com.castillo.dojosninjas.models;

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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name= "ninjas")
public class Ninja {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		

	    @NotEmpty(message = "First name is required!")
	    private String firstName;
	    
	    @NotEmpty(message = "Last name is required!")
	    private String lastName;
	    
	    @NotNull(message = "Age is required!")
	    private double age;
	    
	    //MANY TO ONE RELATIONSHIP WITH TEAMS 
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="ninjas")
	    private Dojo dojo;
	    
	    
	    @Column(updatable=false)
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date createdAt;
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date updatedAt;
		
	    
	        // other getters and setters removed for brevity
	    
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	    
	    //empty constructor
	    public Ninja() {
	    }
	    
	    

	     //loaded constructor 
		public Ninja( String firstName, String lastName, double age) {
			
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
		}
		
		//GENERATE GETTERS AND SETTERS 
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public double getAge() {
			return age;
		}
		public void setAge(double age) {
			this.age = age;
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
		public Dojo getDojo() {
			return dojo;
		}
		public void setDojo(Dojo dojo) {
			this.dojo = dojo;
		}
		
		
		
		
		
		
		
	    
		
}
