package com.kadaijin.kadaijin.DTO;

import com.kadaijin.kadaijin.model.KadaijinModel;

import lombok.Data;

@Data
public class KadaijinDTO {
    private Integer Id;
    private String username;
    private String password;

    // public void entityVdto(KadaijinModel kadaijinModel) {
    // this.Id = kadaijinModel.getId();
    // this.username = kadaijinModel.getUsername();
    // this.password = kadaijinModel.getPassword();
    // }

    public KadaijinDTO entityToDto(KadaijinModel kadaijinModel) {
        KadaijinDTO model = new KadaijinDTO();
        model.Id = kadaijinModel.getId();
        model.username = kadaijinModel.getUsername();
        model.password = kadaijinModel.getPassword();
        return model;
    }
}
