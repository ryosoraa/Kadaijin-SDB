package com.kadaijin.kadaijin.DTO.log;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.internal.bytebuddy.implementation.bind.annotation.Super;

import com.kadaijin.kadaijin.DTO.fiture.ConvertUserDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserDTO {

    @Schema(name = "id", example = "1", required = false)
    private Integer id;

    @Schema(name = "Email", example = "example@gmail.com", required = true)
    private String userName;

    @Schema(name = "Log")
    private Integer totalLogin;

    @Schema(name = "Log")
    private List<LogDTO> log = new ArrayList<>();

}
