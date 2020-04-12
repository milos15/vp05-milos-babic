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

import com.vp.priprema.model.user.Ad;
import com.vp.priprema.model.user.Category;
import com.vp.priprema.service.AdService;
import com.vp.priprema.web.dto.AdDTO;
import com.vp.priprema.web.dto.NewsDTO;


@RestController
public class AdController {
	
	@Autowired
	AdService adService;
	
//	@PreAuthorize("isAuthenticated()")
	@GetMapping("api/ads")
	public ResponseEntity<List<AdDTO>> getAll(Pageable page) {
		List<AdDTO> adDTO = adService.findAll(page).stream()
				.map(ad -> new AdDTO(ad))
				.collect(Collectors.toList());
		
		return new ResponseEntity<>(adDTO, HttpStatus.OK);
	}
	
	// @PreAuthorize("isAuthenticated()")
	@GetMapping(value="api/ads-filter")
	public ResponseEntity<List<AdDTO>> getAllAdsPageByName(
			@RequestParam(required = true, name = "name") String name,
			Pageable page){
		
		List<AdDTO> adDTO = adService.findByNameContains(name, page).stream()
				.map(ad -> new AdDTO(ad))
				.collect(Collectors.toList());
				
		return new ResponseEntity<>(adDTO, HttpStatus.OK);
	}
	

	//@PreAuthorize("isAuthenticated()")
		@GetMapping(value="api/ads/{id}")
		public ResponseEntity<AdDTO> getAd(@PathVariable Long id) {
			final Ad ad = adService.findById(id).get();
			
			if(ad == null ) {
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				final AdDTO adDTO = new AdDTO(ad); 
				return new ResponseEntity<>(adDTO, HttpStatus.OK);
			}
		}
	
		@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
		@PostMapping(value="api/ad")
		public ResponseEntity<AdDTO> createAd(@RequestBody AdDTO adDTO) {
			
			final Ad ad = new Ad();
		
			ad.setName(adDTO.getName());
			ad.setDescription(adDTO.getDescription());
			ad.setPrice(adDTO.getPrice());
			ad.setLocation(adDTO.getLocation());
			ad.setContent(adDTO.getContent());
			
			final Ad savedAd = adService.save(ad);
				
			return new ResponseEntity<>(new AdDTO(savedAd), HttpStatus.CREATED);
		}
		
		
		@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
		@PutMapping(value="api/ads/{id}")
		public ResponseEntity<AdDTO> updateAd(@PathVariable Long id,
				@RequestBody AdDTO adDTO) {
					
			final Ad ad = adService.findById(id).get();

			if (ad == null) {
			   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
			        	
			        ad.setId(id);
			        ad.setName(adDTO.getName());
			        ad.setDescription(adDTO.getDescription());
					ad.setPrice(adDTO.getPrice());
					ad.setLocation(adDTO.getLocation());
					ad.setContent(adDTO.getContent());
			        
					final Ad savedAd = adService.save(ad);
					return new ResponseEntity<>(new AdDTO(savedAd), HttpStatus.OK);
				}
			}
				
				
		//@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
				@DeleteMapping(value ="api/ads/{id}")
			    public ResponseEntity<Void> delete(@PathVariable Long id) {
					final Ad ad = adService.findById(id).get();
				
					if (ad == null) {
			            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			        } else {
			        
			        adService.deleteById(id);
			        return new ResponseEntity<>(HttpStatus.OK);
			    }
			  }		
}
