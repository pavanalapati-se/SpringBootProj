package com.epam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

	User findByUsername(String username);
}
