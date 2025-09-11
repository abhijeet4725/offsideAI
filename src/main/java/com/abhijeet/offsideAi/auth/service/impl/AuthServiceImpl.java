package com.abhijeet.offsideAi.auth.service.impl;

import com.abhijeet.offsideAi.auth.domain.dtos.AuthResponseDto;
import com.abhijeet.offsideAi.auth.domain.dtos.LoginRequestDto;
import com.abhijeet.offsideAi.auth.domain.dtos.LogoutRequestDto;
import com.abhijeet.offsideAi.auth.domain.dtos.RegisterRequestDto;
import com.abhijeet.offsideAi.auth.domain.entities.RefreshToken;
import com.abhijeet.offsideAi.auth.mappers.AuthMapper;
import com.abhijeet.offsideAi.auth.repositories.RefreshTokenRepository;
import com.abhijeet.offsideAi.auth.security.JwtUtil;
import com.abhijeet.offsideAi.auth.service.AuthService;
import com.abhijeet.offsideAi.user.domain.entities.User;
import com.abhijeet.offsideAi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.Encoder;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthMapper authMapper;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private RefreshTokenService refreshTokenService;

    private PasswordEncoder encoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public AuthResponseDto login(LoginRequestDto loginRequestDto) {

        return null;
    }

    @Override
    public AuthResponseDto register(RegisterRequestDto registerRequestDto) {
        if (userRepository.existsByEmail(registerRequestDto.getEmail())){
            throw new RuntimeException("Email already Exists");
        }

        User user = authMapper.toEntity(registerRequestDto);
        user.setPassword(encoder.encode(registerRequestDto.getPassword()));
        userRepository.save(user);

        String accessToken = jwtUtil.generateAccessToken(user.getEmail());
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(user);

        AuthResponseDto response = new AuthResponseDto();
        response.setAccessToken(accessToken);
        response.setRefreshToken(refreshToken.getToken());
        response.setName(user.getName());

        return response;
    }

    @Override
    public AuthResponseDto refresh(String refreshToken) {
        return null;
    }

    @Override
    public void logout(LogoutRequestDto logoutRequestDto) {

    }
}
