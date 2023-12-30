package com.myown.shop.mapper;

import com.myown.shop.dto.UserDTO;
import com.myown.shop.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    User toEntity(UserDTO userDTO);

    UserDTO toUserDto(User user);
}
