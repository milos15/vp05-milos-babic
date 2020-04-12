package com.vp.priprema.web.dto;
import com.vp.priprema.model.user.Category;
import com.vp.priprema.model.user.News;

public class NewsDTO {
	private Long id; 
	private String name; 
	private String description; 
	private String content; 
	private CategoryDTO category;

	public NewsDTO() {
		super();
	}

	public NewsDTO(Long id, String name, String description, String content, CategoryDTO category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.content = content;
		this.category = category;
	}

	public NewsDTO(News news) {
		this.id = news.getId();
		this.name = news.getName();
		this.description = news.getDescription();
		this.content = news.getContent(); 
		this.category = new CategoryDTO(news.getCategory());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}
	
}
