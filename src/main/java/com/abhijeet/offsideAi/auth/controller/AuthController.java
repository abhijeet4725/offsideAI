package com.abhijeet.offsideAi.auth.controller;

import com.abhijeet.offsideAi.auth.domain.dtos.*;
import com.abhijeet.offsideAi.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public AuthResponseDto register(@RequestBody RegisterRequestDto registerRequestDto){
        return authService.register(registerRequestDto);
    }

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody LoginRequestDto loginRequestDto){
        return authService.login(loginRequestDto);
    }
    @PostMapping("/refresh")
    public AuthResponseDto refresh(@RequestBody RefreshRequestDto requestDto){
        return authService.refresh(requestDto.getRefreshToken());

    }
        @PostMapping("/logout")
        public ResponseEntity<String> logout(@RequestBody LogoutRequestDto logoutRequestDto) {
            authService.logout(logoutRequestDto);
            return ResponseEntity.ok("Logout successful");
        }

}
