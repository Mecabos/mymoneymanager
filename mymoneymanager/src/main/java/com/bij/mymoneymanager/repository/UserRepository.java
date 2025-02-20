package com.bij.mymoneymanager.repository;

import com.bij.mymoneymanager.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

    User findByUsername (String username);
}
