package com.vp.priprema.web.dto;

import com.vp.priprema.model.user.Ad;

public class AdDTO {

	private Long id;
	private String name;
	private String description; 
	private int price; 
	private String location; 
	private String content;
	
	public AdDTO() {
	
	}

	public AdDTO(Long id, String name, String description, int price, String location, String content) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.location = location;
		this.content = content;
	}
	
	public AdDTO(Ad ad) {
		
		this.id = ad.getId(); 
		this.name = ad.getName();
		this.description = ad.getDescription();
		this.price = ad.getPrice();
		this.location = ad.getLocation();
		this.content = ad.getContent(); 
		
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

}
