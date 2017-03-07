package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.data.model.User;
import com.sample.data.repository.UserRepository;

/**
 * This is business layer which contains logic related to User.
 * 
 * @author shyam.pareek
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
		;
	}

}
