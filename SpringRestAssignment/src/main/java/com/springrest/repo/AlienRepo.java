package com.springrest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer> {

}
