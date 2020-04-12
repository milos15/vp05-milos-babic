package com.vp.priprema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.vp.priprema.data.AdRepository;
import com.vp.priprema.model.user.Ad;

@Component
public class AdService {
	
	@Autowired
	AdRepository adRepository;

	public Ad save (Ad ad) {
		return adRepository.save(ad);
	}
	

	public Page<Ad> findByNameContains(String name, Pageable page) {
		return adRepository.findByNameContains(name, page);
	}

	
	public Page<Ad> findAll(Pageable pageable) {
		return adRepository.findAll(pageable);
	}

	public List<Ad> findAll() {
		return adRepository.findAll();
	}

	public Optional<Ad> findById(Long id) {
		return adRepository.findById(id);
	}

	public void deleteById(Long id) {
		adRepository.deleteById(id);
	} 
	
}
