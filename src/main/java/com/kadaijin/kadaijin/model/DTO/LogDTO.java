package com.kadaijin.kadaijin.model.DTO;

import java.sql.Timestamp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LogDTO {

    @Schema(name = "times", example = "2023-10-16 00:57:13")
    private Timestamp login;

    @Schema(name = "id", example = "1")
    private Integer ID;
}
