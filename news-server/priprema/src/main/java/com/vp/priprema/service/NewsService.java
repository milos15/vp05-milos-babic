package com.vp.priprema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.vp.priprema.data.NewsRepository;
import com.vp.priprema.model.user.Category;
import com.vp.priprema.model.user.News;

@Component
public class NewsService {
	
	@Autowired
	NewsRepository newsRepository;


	public Page<News> findAll(Pageable pageable) {
		return newsRepository.findAll(pageable);
	}

	public List<News> findAll() {
		return newsRepository.findAll();
	}

	public Optional<News> findById(Long id) {
		return newsRepository.findById(id);
	}

	public Page<News> findByNameContainsAndCategoryEquals(String name, Category category, Pageable page) {
		return newsRepository.findByNameContainsAndCategoryEquals(name, category, page);
	}
	
	
	public News save(News news) {
		return newsRepository.save(news);
	}

	public void deleteById(Long id) {
		newsRepository.deleteById(id);
	}
	
}
