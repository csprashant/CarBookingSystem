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
/** Servoce layer method void saveUSer() 
 * to save single user details into database*/
	public void saveUser(User user) {
		user.setType(2);
		user.setUpdated(new Timestamp(new Date().getTime()));
		repository.save(user);
	}
	/** Service layer method  List<User> getAllUserInfo() 
	 * returns all user from the data base table */
	public List<User> getAllUserInfo() {
		List<User> listUser=(List<User>)repository.findAll();
		return listUser;	
	}
		public User getUserInfo(Integer userId)
		{	Optional<User> user = repository.findById(userId);
			return user.get();
		}
	
	/** Service layer method  void deleteUser(int id)() 
	 * deletes single  user from the data base table */
	public void deleteUser(Integer userId)
	{
		repository.deleteById(userId);
	}


	
	
	
}
