package com.kadaijin.kadaijin.DTO.log;

import java.sql.Timestamp;

import com.kadaijin.kadaijin.DTO.fiture.ConvertLogDTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
public class LogDTO extends ConvertLogDTO {
    private Timestamp timestamp;
    private Integer ID;
}
