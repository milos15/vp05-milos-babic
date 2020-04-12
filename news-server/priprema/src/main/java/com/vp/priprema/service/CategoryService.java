package com.vp.priprema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vp.priprema.data.CategoryRepository;
import com.vp.priprema.model.user.Category;

@Component
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	public Category findByName(String name) {
		return categoryRepository.findByName(name);
	}

	public <S extends Category> S save(S entity) {
		return categoryRepository.save(entity);
	}

	public Category findById(Long id) {
		return categoryRepository.findById(id).get();
	}

	public void deleteById(Long id) {
		categoryRepository.deleteById(id);
	}
}
