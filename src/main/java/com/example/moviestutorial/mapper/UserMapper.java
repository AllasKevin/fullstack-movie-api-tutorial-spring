package com.example.moviestutorial.mapper;

import com.example.moviestutorial.dto.SignUpDto;
import com.example.moviestutorial.dto.UserDto;
import com.example.moviestutorial.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}
