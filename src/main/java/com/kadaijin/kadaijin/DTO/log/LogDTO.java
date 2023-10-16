package com.kadaijin.kadaijin.DTO.log;

import java.sql.Timestamp;

import com.kadaijin.kadaijin.DTO.fiture.ConvertLogDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
public class LogDTO extends ConvertLogDTO {

    @Schema(name = "times", example = "2023-10-16 00:57:13")
    private Timestamp timestamp;

    @Schema(name = "id", example = "1")
    private Integer ID;
}
