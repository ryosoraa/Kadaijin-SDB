package com.kadaijin.kadaijin.DTO.fiture;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.kadaijin.kadaijin.DTO.AccountsDTO;
import com.kadaijin.kadaijin.model.AccountsModel;

@Component
public class ConvertDTO {

    @Autowired
    ModelMapper modelMapper;

    public List<AccountsDTO> listEntityToDto(List<AccountsModel> accountsModel) {
        List<AccountsDTO> dataDTO = new ArrayList<>();

        for (AccountsModel model : accountsModel) {
            /** accountsDTO dto = modelMapper.map(model, accountsDTO.class); */
            dataDTO.add(modelMapper.map(model, AccountsDTO.class));
        }
        return dataDTO;
    }

    public List<AccountsDTO> listEntityToDto(Page<AccountsModel> accountsModel) {
        List<AccountsDTO> dataDTO = new ArrayList<>();

        for (AccountsModel model : accountsModel.getContent()) {
            AccountsDTO dto = modelMapper.map(model, AccountsDTO.class);
            dataDTO.add(dto);
        }
        return dataDTO;
    }

}
