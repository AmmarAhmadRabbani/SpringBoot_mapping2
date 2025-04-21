package com.dailypractice.dto;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import com.dailypractice.entity.User;
import com.dailypractice.entity.UserInfo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private long userId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;

	private UserInfoDto userInfo;

}
