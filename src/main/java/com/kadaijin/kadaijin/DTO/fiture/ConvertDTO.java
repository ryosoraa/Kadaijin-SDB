package com.kadaijin.kadaijin.DTO.fiture;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.kadaijin.kadaijin.DTO.KadaijinDTO;
import com.kadaijin.kadaijin.model.KadaijinModel;

import lombok.Data;

@Component
public class ConvertDTO {

    public KadaijinDTO entityToDto(KadaijinModel kadaijinModel) {
        KadaijinDTO model = new KadaijinDTO();
        model.Id = kadaijinModel.getId();
        model.username = kadaijinModel.getUsername();
        model.password = kadaijinModel.getPassword();
        return model;
    }

    /**
     * 
     * Method Overloading
     * 
     */

    public List<KadaijinDTO> listEntityToDto(List<KadaijinModel> kadaijinModel) {
        List<KadaijinDTO> dataDTO = new ArrayList<>();

        for (KadaijinModel model : kadaijinModel) {
            KadaijinDTO dto = new KadaijinDTO();
            dataDTO.add(dto.entityToDto(model));
        }
        return dataDTO;
    }

    public List<KadaijinDTO> listEntityToDto(Page<KadaijinModel> kadaijinModel) {
        List<KadaijinDTO> dataDTO = new ArrayList<>();

        for (KadaijinModel model : kadaijinModel) {
            KadaijinDTO dto = new KadaijinDTO();
            dataDTO.add(dto.entityToDto(model));
        }
        return dataDTO;
    }

}
