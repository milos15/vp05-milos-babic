package com.vp.priprema.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vp.priprema.model.user.Category;
import com.vp.priprema.model.user.News;
import com.vp.priprema.service.CategoryService;
import com.vp.priprema.service.NewsService;
import com.vp.priprema.web.dto.NewsDTO;



@RestController
public class NewsController {
	
	@Autowired
	NewsService newsService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/api/news-page")
	public ResponseEntity<List<NewsDTO>> getAllNewsPage(
			Pageable page) {
		List<NewsDTO> newsDTO = newsService.findAll(page).stream()
				.map(news -> new NewsDTO(news)).collect(Collectors.toList());
		
		return new ResponseEntity<List<NewsDTO>>(newsDTO, HttpStatus.OK);
	}
	
//	@PreAuthorize("isAuthenticated()")
	@GetMapping(value="/api/news")
	public ResponseEntity<List<NewsDTO>> getAllNewsPageByNameAndCategory(
			@RequestParam(required = true, name = "name") String name,
			@RequestParam(required = true, name="category") Category category,
			Pageable page){
		
		List<NewsDTO> newsDTO = newsService.findByNameContainsAndCategoryEquals(name, category, page)
				.stream()
				.map(news -> new NewsDTO(news))
				.collect(Collectors.toList());
				
		return new ResponseEntity<>(newsDTO, HttpStatus.OK);
	}
	
	//@PreAuthorize("isAuthenticated()")
	@GetMapping(value="/api/news/{id}")
	public ResponseEntity<NewsDTO> getNews(@PathVariable Long id) {
		final News news = newsService.findById(id).get();
		
		if(news == null ) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			final NewsDTO newsDTO = new NewsDTO(news); 
			return new ResponseEntity<>( newsDTO, HttpStatus.OK);
		}
	}
	
	//@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@PostMapping(value="/api/newsPage")
	public ResponseEntity<NewsDTO> createNews(@RequestBody NewsDTO newsDTO) {
		
		final News news = new News();
		news.setName(newsDTO.getName());
		news.setDescription(newsDTO.getDescription());
		news.setContent(newsDTO.getContent());

		Category category = categoryService.findById(newsDTO.getCategory().getId());
		news.setCategory(category);
		
		final News savedNews = newsService.save(news);
		
		return new ResponseEntity<>(new NewsDTO(savedNews), HttpStatus.CREATED);
	}
	
	//@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
		@PutMapping(value="/api/news/{id}")
		public ResponseEntity<NewsDTO> updateNews(@PathVariable Long id,
				@RequestBody NewsDTO newsDTO) {
			
			final News news = newsService.findById(id).get();

			if (news == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        } else {
			
	        news.setId(id);
			news.setName(newsDTO.getName());
			news.setDescription(newsDTO.getDescription());
			news.setContent(newsDTO.getContent());
					
			Category category = categoryService.findById(newsDTO.getCategory().getId());
			
			news.setCategory(category);
			
			final News savedNews = newsService.save(news);
			return new ResponseEntity<>(new NewsDTO(savedNews), HttpStatus.OK);
		}
	}
	
	//@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@DeleteMapping(value ="/api/news/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
		final News news = newsService.findById(id).get();
		if (news == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
        newsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
  }
}
