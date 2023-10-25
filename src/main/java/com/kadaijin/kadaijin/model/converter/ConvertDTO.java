package com.kadaijin.kadaijin.model.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.kadaijin.kadaijin.model.DAO.AccountsModel;
import com.kadaijin.kadaijin.model.DTO.AccountsDTO;

@Component
public class ConvertDTO {

    @Autowired
    ModelMapper modelMapper;

    public List<AccountsDTO> listEntityToDto(List<AccountsModel> accountsModel) {
        List<AccountsDTO> dataDTO = new ArrayList<>();

        for (AccountsModel model : accountsModel) {
            dataDTO.add(modelMapper.map(model, AccountsDTO.class));
        }
        return dataDTO;
    }

    public List<AccountsDTO> listEntityToDto(Page<AccountsModel> accountsModel) {
        List<AccountsDTO> dataDTO = new ArrayList<>();

        for (AccountsModel model : accountsModel.getContent()) {
            dataDTO.add(new AccountsDTO(model));
            // AccountsDTO dto = modelMapper.map(model, AccountsDTO.class);
            // dataDTO.add(dto);
        }
        return dataDTO;
    }

    public List<AccountsDTO> listAccountModelToDTO(List<AccountsModel> AccountsModels) {
        List<AccountsDTO> dto = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        for (AccountsModel model : AccountsModels) {
            System.out.println(mapper.map(model, AccountsDTO.class));
            // dto.add(mapper.map(model, AccountsDTO.class));
            dto.add(new AccountsDTO(model));
        }
        return dto;
    }

}
