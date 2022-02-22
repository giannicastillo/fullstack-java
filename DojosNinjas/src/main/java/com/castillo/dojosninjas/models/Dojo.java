package com.castillo.dojosninjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name= "dojos")
public class Dojo{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	    //ONE TO MANY CODE BELOW!!! 
    //a dojo can have many ninjas, so we can store players in a list
    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
    private List<Ninja> ninjas;

    @NotBlank(message = "Dojo name is required!")
    @Size(min = 3, max = 200, message = "Dojo needs to be between 3-200 characters")
    private String name;
    
    
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
    public Dojo() {
    }
	    
    //loaded constructor 
    public Dojo(String name) {
    	
		this.name = name;
	}
    

    
//GENERATE GETTERS AND SETTERS 

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public List<Ninja> getNinjas() {
		return ninjas;
	}
	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}
    
    
    
    
    
    
    
    
    

    
    
    
//
    
//    @NotNull
//    @Size(min = 5, max = 200)
//    private String description;
//    @NotNull
//    @Size(min = 3, max = 40)
//    private String language;
//    @NotNull
//    @Min(100)
//    private Integer numberOfPages;
//    // This will not allow the createdAt column to be updated after creation

//    
//    public Book() {
//    }
//    public Book(String title, String desc, String lang, int pages) {
//        this.title = title;
//        this.description = desc;
//        this.language = lang;
//        this.numberOfPages = pages;
//    }
//    
//
}
