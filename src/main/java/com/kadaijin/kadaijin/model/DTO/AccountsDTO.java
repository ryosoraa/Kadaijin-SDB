package com.kadaijin.kadaijin.model.DTO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kadaijin.kadaijin.model.converter.ConvertDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Component
public class AccountsDTO extends ConvertDTO {

    @Schema(name = "ID", example = "1", required = false)
    public Integer id;

    @Schema(name = "email", example = "elda@gmail.com", required = true)
    public String email;

    @Schema(name = "password", example = "elda", required = true)
    public String password;

    @Schema(name = "register", example = "2023-10-16T04:09:09", required = false)
    public Timestamp register;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(name = "totalLogin", required = false)
    public Integer totalLogin;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(name = "Log")
    private List<LogDTO> log = new ArrayList<>();

}
