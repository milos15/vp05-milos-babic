package com.vp.priprema.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vp.priprema.service.CategoryService;
import com.vp.priprema.web.dto.CategoryDTO;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("api/categories")
	public ResponseEntity<List<CategoryDTO>> getAll() {
		List<CategoryDTO> categoriesDTO = categoryService.findAll().stream()
				.map(CategoryDTO::new).collect(Collectors.toList());
		return new ResponseEntity<List<CategoryDTO>>(categoriesDTO, HttpStatus.OK);
	}

}
