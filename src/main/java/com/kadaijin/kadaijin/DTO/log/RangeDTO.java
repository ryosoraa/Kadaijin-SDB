package com.kadaijin.kadaijin.DTO.log;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RangeDTO {

    // @Schema(name = "Email", example = "example@gmail.com", required = true)
    // private String userName;

    @Schema(name = "totalLogin")
    private Integer totalLogin;

    // @Schema(name = "Log")
    // private List<LogDTO> log = new ArrayList<>();

}
