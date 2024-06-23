package com.gfg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gfg.model.MyUser;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Integer>
{
	public Optional<MyUser> findByUsername(String username);
}
