package com.gfg.jdblblr2librarymanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

// @RedisHash is a Spring Data Redis annotation used to map a class to a Redis hash. 
// Redis hashes are a data type in Redis that represent a collection of key-value pairs

// Mapping Java Objects to Redis Hashes: The @RedisHash annotation is used to indicate 
// that instances of the annotated class should be stored in a Redis hash. 
// This allows you to work with Java objects while storing the underlying data in Redis.


@RedisHash
@Builder
@AllArgsConstructor
@Data
public class _Book 
{
    @Id
    String title;
    
    private String author;
    
    private Integer qty;
}
