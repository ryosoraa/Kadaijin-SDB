package com.kadaijin.kadaijin.DTO.fiture;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.kadaijin.kadaijin.DTO.KadaijinDTO;
import com.kadaijin.kadaijin.model.AccountsModel;

@Component
public class ConvertDTO {

    @Autowired
    ModelMapper modelMapper;

    public List<KadaijinDTO> listEntityToDto(List<AccountsModel> accountsModel) {
        List<KadaijinDTO> dataDTO = new ArrayList<>();

        for (AccountsModel model : accountsModel) {
            /** KadaijinDTO dto = modelMapper.map(model, KadaijinDTO.class); */
            dataDTO.add(modelMapper.map(model, KadaijinDTO.class));
        }
        return dataDTO;
    }

    public List<KadaijinDTO> listEntityToDto(Page<AccountsModel> accountsModel) {
        List<KadaijinDTO> dataDTO = new ArrayList<>();

        for (AccountsModel model : accountsModel.getContent()) {
            KadaijinDTO dto = modelMapper.map(model, KadaijinDTO.class);
            dataDTO.add(dto);
        }
        return dataDTO;
    }

}
