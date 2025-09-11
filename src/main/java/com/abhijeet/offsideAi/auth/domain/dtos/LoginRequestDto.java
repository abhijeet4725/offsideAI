package com.abhijeet.offsideAi.auth.domain.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Setter;

@Data
public class LoginRequestDto {

    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}
