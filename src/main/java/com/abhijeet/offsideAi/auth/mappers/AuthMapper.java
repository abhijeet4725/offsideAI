package com.abhijeet.offsideAi.auth.mappers;

import com.abhijeet.offsideAi.auth.domain.dtos.RegisterRequestDto;
import com.abhijeet.offsideAi.user.domain.entities.User;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {
    public User toEntity(RegisterRequestDto dto) {
        return User.builder()
                .email(dto.getEmail())
                .name(dto.getName())
                .password(dto.getPassword()) // Will encode later
                .build();
    }

}
