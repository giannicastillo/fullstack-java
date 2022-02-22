package com.castillo.dojosninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.castillo.dojosninjas.models.Dojo;
import com.castillo.dojosninjas.models.Ninja;
import com.castillo.dojosninjas.repositories.DojoRepository;
import com.castillo.dojosninjas.repositories.NinjaRepository;

@Service
public class AppService {
	
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	
	
	public AppService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
	//create a dojo
	
	public Dojo createDojo(Dojo d) {
		return this.dojoRepo.save(d);
	}
	
	//get all the dojos
	public List <Dojo> getAllDojos(){
		return (List<Dojo>)this.dojoRepo.findAll();
	}
	
	//create a ninja 
	
	public Ninja createNinja(Ninja n) {
		return this.ninjaRepo.save(n);
	}
	
	//get one dojo by id
	public Dojo getOneDojo(Long id){
		return this.dojoRepo.findById(id).orElse(null);
	}
	
	
	
	

}
