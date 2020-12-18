package com.casestudy.contactapplogin.repository;

import org.springframework.data.repository.CrudRepository;

import com.casestudy.contactapplogin.model.User;


public interface userRepository extends CrudRepository<User, Integer> {

}
