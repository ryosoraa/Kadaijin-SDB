package com.kadaijin.kadaijin.model.DTO;

import java.sql.Timestamp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RangeCustomDTO {

    @Schema(name = "email", example = "ryo@gmail.com")
    private String email;

    @Schema(name = "start", example = "2023-10-23 18:50:13")
    private Timestamp start;

    @Schema(name = "end", example = "2023-10-23 18:50:13")
    private Timestamp end;

    @Schema(name = "page", example = "1")
    private Integer page;

    @Schema(name = "size", example = "10")
    private Integer size;

    public RangeCustomDTO(String email, String start, String end, Integer page, Integer size) {
        this.email = email;
        this.start = Timestamp.valueOf(start);
        this.end = Timestamp.valueOf(end);
        this.page = page;
        this.size = size;
    }

}
