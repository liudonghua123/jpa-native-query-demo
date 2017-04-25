package com.liudonghua.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liudonghua.demo.model.User;
import com.liudonghua.demo.model.UserCount;
import com.liudonghua.demo.model.UserPartial;
import com.liudonghua.demo.service.UserService;

@RestController
@RequestMapping(value = "/")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/add")
	public User add() {
		User persistedUser = userService.save(new User("username", "password"));
		return persistedUser;
	}

	@GetMapping(value = { "/userPartial", "/userPartial/{username}" })
	public List<UserPartial> listPartial(@PathVariable(name = "username", required = false) String username) {
		List<UserPartial> persistedUsers = userService.getUserPartials(username);
		return persistedUsers;
	}

	@GetMapping(value = "/count")
	public UserCount count() {
		UserCount userCount = userService.count();
		return userCount;
	}

}
