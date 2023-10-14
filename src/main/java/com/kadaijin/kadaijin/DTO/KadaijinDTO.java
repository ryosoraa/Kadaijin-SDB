package com.kadaijin.kadaijin.DTO;

import org.springframework.stereotype.Component;

import com.kadaijin.kadaijin.DTO.fiture.ConvertDTO;
import com.kadaijin.kadaijin.model.KadaijinModel;

import lombok.Data;

@Data
@Component
public class KadaijinDTO extends ConvertDTO {
    public Integer Id;
    public String username;
    public String password;

}
