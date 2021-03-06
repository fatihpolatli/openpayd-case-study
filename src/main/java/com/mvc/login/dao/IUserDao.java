package com.mvc.login.dao;

import java.util.List;

import com.mvc.login.entity.User;
import com.mvc.login.exception.NoUserException;

public interface IUserDao {

	User findByUsername(String username) throws NoUserException;

	User findByEmail(String email);

	User save(User user);

	List<User> findAll();

	User findById(Long userId) throws NoUserException;

}
