package com.kadaijin.kadaijin.DTO.log;

import java.util.ArrayList;
import java.util.List;

import com.kadaijin.kadaijin.DTO.fiture.ConvertUserDTO;
import com.kadaijin.kadaijin.model.log.LogModel;

import lombok.Data;

@Data
public class UserDTO extends ConvertUserDTO {

    private Integer id;
    private String userName;
    private int totalLogin;
    private List<LogDTO> log = new ArrayList<>();
}
