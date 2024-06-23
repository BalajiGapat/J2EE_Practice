package com.gfg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfg.entity.MyUser;

@Repository
public interface UserRepository extends JpaRepository<MyUser, String>
{
	public MyUser findByUsername(String username);	
}
