package com.mvc.login.controller;

import com.mvc.login.exception.NoUserException;
import com.mvc.login.service.IUserService;
import com.mvc.login.util.GenericResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/restful/users")
public class UserController {

	@Autowired
	IUserService userService;

	@GetMapping
	public GenericResponse getUserList() {

		return new GenericResponse(null, null, userService.getUserList());

	}

	@GetMapping("{userId}")
	public GenericResponse getUserById(@PathVariable Long userId) throws NoUserException {

		return new GenericResponse(null, null, userService.findById(userId));

	}

}