package com.nbs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nbs.model.User;
@Repository
public interface UserRepository extends CrudRepository<User,Integer>  {
public User findByEmailAndPassword(String email,String password);
}
