package com.vp.priprema.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vp.priprema.model.user.SecurityUser;

public interface UserRepository extends JpaRepository<SecurityUser, Long> {
	  public SecurityUser findByUsername(String username);
}
