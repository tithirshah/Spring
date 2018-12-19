 package com.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.Alien;
import com.springmvc.model.AlienList;

@Controller
 public class AlienController {
	
	
	@GetMapping("/")
	public ModelAndView getAliens(ModelAndView mv,@ModelAttribute("alienList") AlienList alienList)
	{
		//System.out.println("Alien controller");
		//AlienList alienList=new AlienList();
		List<Alien> aliens = new ArrayList<Alien>();
		aliens.add(new Alien(101,"Tithi",25));
		aliens.add(new Alien(102,"xyz",26));
		aliens.add(new Alien(103,"abc",27));
		aliens.add(new Alien(104,"def",28));
		aliens.add(new Alien(105,"aaa",29));
		aliens.add(new Alien(106,"bbb",30));
		aliens.add(new Alien(107,"ccc",31));
		aliens.add(new Alien(108,"ddd",32));
		aliens.add(new Alien(109,"eee",33));
		aliens.add(new Alien(110,"efg",55));
		alienList.setAliens(aliens);
		
		mv.setViewName("AlienForm");
		return mv;
	}
	
	
	@PostMapping("save")
	public ModelAndView saveAliens(ModelAndView mv,@ModelAttribute("alienList") AlienList alienList)
	{
		//System.out.println(alienList);
		//System.out.println(alienList.getAliens());
		List<Alien> aliens = alienList.getAliens();
		
		if(aliens!=null && aliens.size() > 0) {
			
			for (Alien alien : aliens) {
				System.out.print(alien);
			}
		}
		mv.setViewName("DisplayAlien");
		return mv;
	}


}
