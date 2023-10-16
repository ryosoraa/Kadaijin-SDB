package com.kadaijin.kadaijin.DTO;

import org.springframework.stereotype.Component;

import com.kadaijin.kadaijin.DTO.fiture.ConvertDTO;
import com.kadaijin.kadaijin.model.KadaijinModel;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Component
public class KadaijinDTO extends ConvertDTO {

    @Schema(name = "ID", example = "1", required = true)
    public Integer Id;

    @Schema(name = "username", example = "elda@gmail.com", required = true)
    public String username;

    @Schema(name = "password", example = "elda", required = true)
    public String password;

    public String created;

}
