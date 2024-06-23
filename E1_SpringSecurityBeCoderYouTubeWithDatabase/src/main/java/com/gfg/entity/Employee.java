package com.gfg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity(name="emp")
public class Employee
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="emp_name", length = 50, unique = true, nullable = false)
	private String empName;
	
	@Column(name="email", length = 50, unique = true, nullable = false)
	private String email;
	
	@Column(name="password", length = 225, unique = true, nullable = false)
	private String password;
	
	// @Transient
	// private String confirmPassword;
	
	@Column
	private String empDep;
	
	@Column
	private String role;
}
