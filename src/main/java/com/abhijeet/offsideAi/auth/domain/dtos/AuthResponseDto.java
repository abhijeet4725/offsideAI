package com.abhijeet.offsideAi.auth.domain.dtos;


import lombok.Data;

@Data
public class AuthResponseDto {

    private String name;
    private String accessToken;
    private String refreshToken;

}
