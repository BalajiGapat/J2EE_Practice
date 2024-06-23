package com.gfg.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Student2
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private Integer age;

    @ManyToMany(cascade =CascadeType.ALL, fetch = FetchType.LAZY )
    @JoinTable
	(
        name = "student_course",
        joinColumns =@JoinColumn(name = "student_id"), 
		inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course2> courses = new HashSet<>();
}


