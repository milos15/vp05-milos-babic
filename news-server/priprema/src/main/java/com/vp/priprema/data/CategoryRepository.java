package com.vp.priprema.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vp.priprema.model.user.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	Category findByName(String name);
}
