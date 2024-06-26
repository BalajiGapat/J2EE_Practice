package com.gfg.jdblblr2librarymanagement.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gfg.jdblblr2librarymanagement.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> 
{
    Optional<User> findByUsername(String username);
}
