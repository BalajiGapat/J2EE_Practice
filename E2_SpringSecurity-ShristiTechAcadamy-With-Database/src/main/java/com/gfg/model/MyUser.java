package com.gfg.model;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity(name="my_user")
public class MyUser 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name="user_name", length= 50, nullable= false, unique= true)
	private String username;
	
	@Column(nullable = false, unique = true)
	private String password;
	
	@ElementCollection(fetch = FetchType.EAGER )
	@CollectionTable(name="user_authorities", joinColumns = @JoinColumn(name="user_id"))
	private Set<String> authorities; // this property is not created in my_user table		
}
