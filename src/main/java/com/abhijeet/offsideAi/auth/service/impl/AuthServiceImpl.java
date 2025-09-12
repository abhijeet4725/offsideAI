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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.Encoder;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final AuthMapper authMapper;

    private final AuthenticationManager authenticationManager;

    @Autowired
    private final RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private final RefreshTokenService refreshTokenService;

    private final PasswordEncoder encoder;

    @Autowired
    private final JwtUtil jwtUtil;

    @Override
    public AuthResponseDto login(LoginRequestDto loginRequestDto) {
        if (!userRepository.existsByEmail(loginRequestDto.getEmail())) {
            throw new RuntimeException("User not found");
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getEmail(),
                        loginRequestDto.getPassword()
                )
        );

        User user = userRepository.findByEmail(loginRequestDto.getEmail());
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        String accessToken = jwtUtil.generateAccessToken(user.getEmail());
        RefreshToken refreshToken = refreshTokenRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Refresh token not found"));

        AuthResponseDto response = new AuthResponseDto();
        response.setAccessToken(accessToken);
        response.setRefreshToken(refreshToken.getToken());
        response.setName(user.getName());

        return response;
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
        RefreshToken refreshTokenEntity = refreshTokenService.findByToken(refreshToken)
                .orElseThrow(() -> new RuntimeException("Token Not Valid"));

        refreshTokenService.verifyExpiration(refreshTokenEntity);

        User user = refreshTokenEntity.getUser();
        String newAccessToken = jwtUtil.generateAccessToken(user.getEmail());

        AuthResponseDto response = new AuthResponseDto();
        response.setAccessToken(newAccessToken);
        response.setRefreshToken(refreshTokenEntity.getToken());
        response.setName(user.getName());

        return response;
    }

    @Override
    public void logout(LogoutRequestDto logoutRequestDto) {

    }
}
