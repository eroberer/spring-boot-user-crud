package com.eroberer.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.eroberer.crud.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
