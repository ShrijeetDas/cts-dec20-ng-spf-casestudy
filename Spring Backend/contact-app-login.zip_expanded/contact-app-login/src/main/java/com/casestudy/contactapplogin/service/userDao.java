package com.casestudy.contactapplogin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.contactapplogin.exception.UserNotFound;
import com.casestudy.contactapplogin.model.User;
import com.casestudy.contactapplogin.repository.userRepository;


@Service
public class userDao {
	@Autowired
	private userRepository dao;
	
	public User save(User user) {
		User createdUser = dao.save(user);
		return createdUser;
	}
	
	
	public  User findById(int id) throws UserNotFound {
		Optional<User> option = dao.findById(id);
		if(option.isPresent())
			return option.get();
		else
			throw new UserNotFound("User not found");
	}
	
	public String deleteUser(int id) throws UserNotFound  {
		Optional<User> option = dao.findById(id);
		if(option.isPresent()) {
			dao.deleteById(id);
			return "Success";
		}
		else
			throw new UserNotFound("User not found");
	}
	
	
	public User login(int id, String password) throws UserNotFound  {
		Optional<User> option = dao.findById(id);
		if(option.isPresent()) {
			User user = option.get();
			if(user.getPassword().equals(password)) {
			return user;
			}
			throw new UserNotFound("User not found");
		}
		else
			throw new UserNotFound("User not found");
	}


	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
