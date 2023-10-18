package com.kadaijin.kadaijin.DTO.log;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class RangeDTO {

    private String userName;
    private List<LogDTO> log = new ArrayList<>();

}
