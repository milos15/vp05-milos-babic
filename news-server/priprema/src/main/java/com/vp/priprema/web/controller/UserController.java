package com.vp.priprema.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vp.priprema.security.TokenUtils;
import com.vp.priprema.service.UserDetailsServiceImpl;
import com.vp.priprema.web.dto.LoginDTO;
import com.vp.priprema.web.dto.TokenDTO;

@RestController
public class UserController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	TokenUtils tokenUtils;
	
//	@PreAuthorize("hasAnyAuthority('ADMIN', 'SKORO_ADMIN')")
//	@PreAuthorize("isAuthenticated()") // Mora biti ulogovan, nebitna uloga.
	@PostMapping(value = "/api/login")
	public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO) {
        try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
					loginDTO.getUsername(), loginDTO.getPassword());
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails details = userDetailsService.loadUserByUsername(loginDTO.getUsername());
            String genToken = tokenUtils.generateToken(details);
            return new ResponseEntity<TokenDTO>(new TokenDTO(genToken), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<TokenDTO>(new TokenDTO(""), HttpStatus.BAD_REQUEST);
        }
	}
	
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@GetMapping("/api/test")
	public ResponseEntity<String> countries() {
		return new ResponseEntity<>("HELLO ADMIN", HttpStatus.OK);
	}
}
