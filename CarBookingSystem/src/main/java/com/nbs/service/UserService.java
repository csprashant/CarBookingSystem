package com.nbs.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nbs.model.User;
import com.nbs.repository.UserRepository;

@Service

public class UserService {

	private final UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	/**
	 * save a new User class object
	 * @param user User class object
	 */
	public void saveUser(User user) {
		user.setType(2);
		user.setUpdated(new Timestamp(new Date().getTime()));
		repository.save(user);
	}

	/**
	 *  Returns all User details
	 *@return returns List<User> List contains Users 
	 */
	public List<User> getAllUserInfo() {
		List<User> listUser = (List<User>) repository.findAll();
		return listUser;
	}
	/**
 	*Returns single User class object
 	*@param userId  A Integer value represents userId 
 */
	public User getUserInfo(Integer userId) {
		User user = repository.findById(userId).get();
		return user;
	}

	/**
	*	Deletes single User
	*@param vehicleId  a Integer value represents userId
	*/
	public void deleteUser(Integer userId) {
		repository.deleteById(userId);
	}
	/**
	 * checks the correct user for username and password
	 * @param emailId	 emailid of the user
	 * @param password password of the user
	 * @return	User object if username and password matched
	 */
	public User login(String emailId, String password) {
		return repository.findByEmailAndPassword(emailId, password);
	}

}
