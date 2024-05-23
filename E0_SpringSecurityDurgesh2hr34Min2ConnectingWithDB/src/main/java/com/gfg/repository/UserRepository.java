package com.gfg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfg.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>
{
	
}
