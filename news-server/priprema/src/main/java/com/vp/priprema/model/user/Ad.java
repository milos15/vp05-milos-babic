package com.vp.priprema.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// Podatke za tabelu sam smestio u db-init.sql

@Entity
public class Ad {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private String description; 
	private int price; 
	private String location; 
	private String content;
	
	public Ad() {
		
	}

	public Ad(Long id, String name, String description, int price, String location, String content) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.location = location;
		this.content = content;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Ad [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", location="
				+ location + ", content=" + content + "]";
	} 
}
