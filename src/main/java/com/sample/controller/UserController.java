package com.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.data.model.User;
import com.sample.service.UserService;

/**
 * This is controller used to expose URL for application to access User.
 * 
 * @author shyam.pareek
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserService userSrvice;

	@ResponseBody
	@RequestMapping("/getUser/{id}")
	public User getUser(@PathVariable Long id) {

		return userSrvice.getUser(id);
	}

	@ResponseBody
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public User addUser(@RequestBody User user) {

		return userSrvice.addUser(user);
	}

	@ResponseBody
	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user) {

		return userSrvice.updateUser(user);
	}

	@ResponseBody
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {

		userSrvice.deleteUser(id);

		return "Delete Success !!!";
	}
}
