package org.eyesky.back.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Data
public class LoginRequest {
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
