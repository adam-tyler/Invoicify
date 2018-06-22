package com.el.ally.invoicify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository < User, Integer> {
	
	//add special method to find users by username
    User findByUsername(String username);
}
