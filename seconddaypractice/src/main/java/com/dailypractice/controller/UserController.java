package com.dailypractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailypractice.dto.UserDto;
import com.dailypractice.response.SuccessResponse;
import com.dailypractice.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/add")
	public ResponseEntity<SuccessResponse> add(@RequestBody UserDto userDto) {
		UserDto add = service.add(userDto);
		if (add != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "added", add), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "adding failed", null), HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getAll")
	public ResponseEntity<SuccessResponse> getAll() {
		List<UserDto> all = service.getAll();
		if (all != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "getting successfull", all), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "getting failed", null), HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/get/{userId}")
	public ResponseEntity<SuccessResponse> getById(@PathVariable long userId) {
		UserDto byId = service.getById(userId);
		if (byId != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "successfull", byId), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "id invalid", null), HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/update")
	public ResponseEntity<SuccessResponse> update(@RequestBody UserDto userDto) {
		UserDto update = service.update(userDto);
		if (update != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "updated", update), HttpStatus.OK);

		}
		return new ResponseEntity<>(new SuccessResponse(true, "updation failed", null), HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<SuccessResponse> deleteUserById(@PathVariable long userId) {
		UserDto deleteUserById = service.deleteUserById(userId);
		if (deleteUserById != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "deleted", deleteUserById), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "not deleted", null), HttpStatus.BAD_REQUEST);
	}

}
