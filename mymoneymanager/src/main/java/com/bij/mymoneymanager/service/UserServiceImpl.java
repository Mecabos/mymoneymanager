package com.bij.mymoneymanager.service;

import com.bij.mymoneymanager.model.User;
import com.bij.mymoneymanager.repository.RoleRepository;
import com.bij.mymoneymanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    /*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
       /* user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = roleRepository.findByRole("USER");
        user.setRoleSet(new HashSet<Role>(Arrays.asList(role)));
        return userRepository.save(user);*/
        return null;
    }

    @Override
    public User findByUsername(String username) throws UsernameNotFoundException {

        User foundUser = userRepository.findByUsername(username);

        if (foundUser != null)
            return foundUser;

        throw new UsernameNotFoundException("User not found with username : " + username);

    }
}
