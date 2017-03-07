package com.sample.service;

import com.sample.data.model.User;

/**
 * This is abstract layer to User.
 * 
 * @author shyam.pareek
 *
 */
public interface UserService {

	User addUser(User user);

	User getUser(Long id);

	User updateUser(User user);

	void deleteUser(Long id);
}
