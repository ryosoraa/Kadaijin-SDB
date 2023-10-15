package com.kadaijin.kadaijin.DTO.log;

import java.util.ArrayList;
import java.util.List;

import com.kadaijin.kadaijin.DTO.fiture.ConvertUserDTO;
import com.kadaijin.kadaijin.model.log.LogModel;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
public class UserDTO extends ConvertUserDTO{

    private String userName;
    private List<LogModel> log = snew ArrayList<>();
    private int totalLogin;
}
