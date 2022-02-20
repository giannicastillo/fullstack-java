package com.castillo.crudsafetravels.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.castillo.crudsafetravels.models.TravelItem;

//REPOS HAVE DIRECT CONNECTION TO SQL DB 
@Repository
public interface TravelItemRepository extends CrudRepository<TravelItem, Long>{
	

}

