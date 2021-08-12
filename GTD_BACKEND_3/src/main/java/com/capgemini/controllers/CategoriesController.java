package com.capgemini.controllers;

import javax.websocket.OnError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
}
