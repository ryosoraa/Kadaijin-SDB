package com.kadaijin.kadaijin.model.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LoginDTO {

    @Schema(name = "email", defaultValue = "ryo@gmail.com")
    private String email;

    @Schema(name = "password", defaultValue = "ryo")
    private String password;
}
