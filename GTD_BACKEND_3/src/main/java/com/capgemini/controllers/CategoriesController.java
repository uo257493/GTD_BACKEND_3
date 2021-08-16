package com.capgemini.controllers;

import java.util.List;

import javax.websocket.OnError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.Categories;
import com.capgemini.service.CategoriesService;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

	@Autowired
	private CategoriesService categoriesService;



	@GetMapping("/{id}")
	public Categories findById(@PathVariable Long id) {
		return categoriesService.findById(id);
	}
	
	@GetMapping("/bypropietarioid/{id}")
	public List<Categories> findByPropietarioId(@PathVariable Long id){
		return categoriesService.findByPropietario(id);
	}

	@GetMapping("/byname/{name}")
	public List<Categories> findByName(@PathVariable String name){
		return categoriesService.findByName(name);
	}
	
	@PostMapping("/")
	public Categories addCategory(@RequestBody Categories c) {

	
		return categoriesService.save(c);
	}
	
	@PutMapping("/")
	public Categories updateCategory(@RequestBody Categories c) {

	
		return categoriesService.save(c);
	}
	
}
