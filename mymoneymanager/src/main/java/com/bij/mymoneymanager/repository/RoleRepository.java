package com.bij.mymoneymanager.repository;

import com.bij.mymoneymanager.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Integer> {

    Role findByRole (String role);
}
