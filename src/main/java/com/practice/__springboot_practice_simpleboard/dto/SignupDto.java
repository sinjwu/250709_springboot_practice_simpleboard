package com.practice.__springboot_practice_simpleboard.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupDto {
    @NotBlank
    @Size(min=3, max=50)
    private String username;

    @NotBlank
    @Size(min=6, max=100)
    private String password;
}
