package com.vp.priprema.model.user;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private Long id;
	private String name; 
	
	@JsonIgnore
	@OneToMany(mappedBy ="category", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<News> news = new HashSet<>();

	public Category() {
		super();
	}

	public Category(Long id, String name, Set<News> news) {
		super();
		this.id = id;
		this.name = name;
		this.news = news;
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

	public Set<News> getNews() {
		return news;
	}

	public void setNews(Set<News> news) {
		this.news = news;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", news=" + news + "]";
	} 
}
