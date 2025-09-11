package com.abhijeet.offsideAi.auth.domain.dtos;

import lombok.Data;

@Data
public class LogoutRequestDto {
    private String refreshToken;
}

