package com.dailypractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailypractice.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

}
