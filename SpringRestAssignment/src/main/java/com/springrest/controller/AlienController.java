 package com.springrest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.model.Alien;
import com.springrest.repo.AlienRepo;

@RestController
 public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@GetMapping("/aliens")
	@ResponseStatus(HttpStatus.OK)
	public List<Alien> getAliens()
	{
		
		List<Alien> aliens = new ArrayList<Alien>();
		aliens=repo.findAll();


		return aliens;
		
		
	}
	@GetMapping("/alien/{aid}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Alien> getAlien(@PathVariable int aid)
	{
		Optional<Alien> alien=repo.findById(aid);
		
		System.out.println("Alien"+alien.isPresent());
		if(!alien.isPresent())
			throw new NullPointerException();
		return alien;
		
	}
	@PostMapping("/alien")
	@ResponseStatus(HttpStatus.CREATED)
	public Alien saveAlien(@RequestBody Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	
	@DeleteMapping("alien/{aid}")
	public void deleteAlien(@PathVariable int aid)
	{
		Optional<Alien> alien=repo.findById(aid);
		System.out.println("Alien"+alien.isPresent());
		if(!alien.isPresent())
			throw new NullPointerException();
		repo.deleteById(aid);
	}
	
	@PutMapping("alien")
	public Alien updateAlien(@RequestBody Alien alien)
	{
		if(repo.existsById(alien.getAid()))
			repo.save(alien);
		return alien;
	}
	
	
	
	
	


}
