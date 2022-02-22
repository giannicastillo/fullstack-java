package com.castillo.dojosninjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.castillo.dojosninjas.models.Ninja;



@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {

}
