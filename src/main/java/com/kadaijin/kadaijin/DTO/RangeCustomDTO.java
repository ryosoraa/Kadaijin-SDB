package com.kadaijin.kadaijin.DTO;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RangeCustomDTO {

    @Schema(name = "email", example = "elda@gmail.com")
    private String email;

    @Schema(name = "start", example = "2023-10-23 18:50:13")
    private Timestamp start;

    @Schema(name = "end", example = "2023-10-23 18:50:13")
    private Timestamp end;

    public RangeCustomDTO(String email, String start, String end) {
        this.email = email;
        this.start = Timestamp.valueOf(start);
        this.end = Timestamp.valueOf(end);
    }

}
