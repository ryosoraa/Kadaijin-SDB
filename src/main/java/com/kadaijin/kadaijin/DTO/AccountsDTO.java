package com.kadaijin.kadaijin.DTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kadaijin.kadaijin.DTO.fiture.ConvertDTO;
import com.kadaijin.kadaijin.DTO.log.LogDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Component
public class AccountsDTO extends ConvertDTO {

    @Schema(name = "ID", example = "1", required = false)
    public Integer Id;

    @Schema(name = "username", example = "elda@gmail.com", required = true)
    public String username;

    @Schema(name = "password", example = "elda", required = true)
    public String password;

    @Schema(name = "register", example = "2023-10-16T04:09:09", required = false)
    public String register;

    @Schema(name = "totalLogin", required = false)
    public Integer totalLogin;

    @Schema(name = "Log")
    private List<LogDTO> log = new ArrayList<>();

}
