package com.vp.priprema.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vp.priprema.model.user.Ad;

public interface AdRepository extends JpaRepository<Ad, Long> {
	
	Page<Ad> findByNameContains(String name, Pageable page);
}
