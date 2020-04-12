package com.vp.priprema.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class News {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name; 
	private String description;
	
	@Column(length = 500)
	private String content; 
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;

	
	public News() {
		super();
	}

	public News(Long id, String name, String description, String content, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.content = content;
		this.category = category;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", name=" + name + ", description=" + description + ", content=" + content
				+ ", category=" + category + "]";
	} 
	
}
