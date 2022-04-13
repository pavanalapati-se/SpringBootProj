package com.epam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@Column(name="USER_ID")
	private long id;
	
	@Column(name="USERNAME",nullable = false,unique = true)
	private String username;
	
	private String password;
	
	private boolean enabled=true;
}
