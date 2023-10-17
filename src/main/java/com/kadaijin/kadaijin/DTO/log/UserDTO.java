package com.kadaijin.kadaijin.DTO.log;

import java.util.ArrayList;
import java.util.List;

import com.kadaijin.kadaijin.DTO.fiture.ConvertUserDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserDTO extends ConvertUserDTO {

    @Schema(name = "id", example = "1", required = false)
    private Integer id;

    @Schema(name = "Email", example = "example@gmail.com", required = true)
    private String userName;


    @Schema(name = "Log")
    private List<LogDTO> log = new ArrayList<>();
}
