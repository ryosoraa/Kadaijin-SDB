package com.kadaijin.kadaijin.DTO.fiture;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.kadaijin.kadaijin.DTO.log.LogDTO;

import com.kadaijin.kadaijin.DTO.AccountsDTO;
import com.kadaijin.kadaijin.model.log.LogModel;
import com.kadaijin.kadaijin.model.AccountsModel;

@Component
public class ConvertAccountsDTO {

    @Autowired
    ModelMapper modelMapper;

    public List<AccountsDTO> listModelToDTO(List<AccountsModel> AccountsModels) {
        List<AccountsDTO> dto = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        for (AccountsModel model : AccountsModels) {
            System.out.println(mapper.map(model, AccountsDTO.class));
            dto.add(mapper.map(model, AccountsDTO.class));
        }
        return dto;
    }

    public List<AccountsDTO> listModelToDTO(Page<AccountsModel> AccountsModels) {
        ModelMapper mapper = new ModelMapper();
        List<AccountsDTO> dto = new ArrayList<>();
        for (AccountsModel model : AccountsModels) {
            dto.add(mapper.map(model, AccountsDTO.class));
        }
        return dto;
    }

    public List<LogDTO> listModelToLogDTO(List<LogModel> logModels) {
        List<LogDTO> dto = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        for (LogModel model : logModels) {
            System.out.println(mapper.map(model, LogDTO.class));
            dto.add(mapper.map(model, LogDTO.class));
        }
        return dto;
    }

}
