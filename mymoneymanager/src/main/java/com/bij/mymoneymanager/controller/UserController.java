package com.bij.mymoneymanager.controller;

import com.bij.mymoneymanager.dto.user.UserDto;
import com.bij.mymoneymanager.dto.user.UserForCreationDto;
import com.bij.mymoneymanager.model.User;
import com.bij.mymoneymanager.service.UserService;
import com.bij.mymoneymanager.util.DTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController {

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private UserService userService ;

    @PostMapping
    @ResponseBody
    public UserDto addUser (@DTO(UserForCreationDto.class) User user){
        return modelMapper.map(userService.create(user), UserDto.class);
    }

}
