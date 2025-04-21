package com.dailypractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailypractice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
