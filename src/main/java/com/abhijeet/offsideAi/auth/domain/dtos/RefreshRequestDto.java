package com.abhijeet.offsideAi.auth.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RefreshRequestDto {
    @NotBlank
    private String refreshToken;
}
