package com.abhijeet.offsideAi.auth.domain.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Setter;

@Data
public class RegisterRequestDto {

    @Email
    private String email;

    @NotBlank
    private String name;

    @Size(min = 6, max = 40)
    private String password;
}
