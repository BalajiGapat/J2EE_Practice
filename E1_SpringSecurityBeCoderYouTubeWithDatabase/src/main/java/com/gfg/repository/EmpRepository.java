package com.gfg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gfg.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Long>
{
	public Employee findByEmail(String email);
}
