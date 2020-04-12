package com.vp.priprema.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vp.priprema.model.user.Category;
import com.vp.priprema.model.user.News;

public interface NewsRepository extends JpaRepository<News, Long> {
		
	Page<News> findByNameContainsAndCategoryEquals(String name, Category category, Pageable page);
}
