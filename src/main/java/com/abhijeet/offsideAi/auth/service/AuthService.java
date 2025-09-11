package com.abhijeet.offsideAi.auth.service;

import com.abhijeet.offsideAi.auth.domain.dtos.AuthResponseDto;
import com.abhijeet.offsideAi.auth.domain.dtos.LoginRequestDto;
import com.abhijeet.offsideAi.auth.domain.dtos.LogoutRequestDto;
import com.abhijeet.offsideAi.auth.domain.dtos.RegisterRequestDto;

public interface AuthService {
    AuthResponseDto login(LoginRequestDto loginRequestDto);
    AuthResponseDto register(RegisterRequestDto registerRequestDto);
    AuthResponseDto refresh(String refreshToken);
    void logout(LogoutRequestDto logoutRequestDto);
}
