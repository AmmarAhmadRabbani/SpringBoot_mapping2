package com.dailypractice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {
	private long infoId;
	private String mobileNumber;
	private String gender;
	private String address;

//	private User user;

}
