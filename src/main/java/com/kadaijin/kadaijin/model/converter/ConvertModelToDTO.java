package com.kadaijin.kadaijin.model.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.kadaijin.kadaijin.repository.AccountsRepository;
import com.kadaijin.kadaijin.repository.LogRepository;
import com.kadaijin.kadaijin.model.DAO.AccountsModel;
import com.kadaijin.kadaijin.model.DAO.LogModel;
import com.kadaijin.kadaijin.model.DTO.AccountsDTO;
import com.kadaijin.kadaijin.model.DTO.LogDTO;
import com.kadaijin.kadaijin.model.DTO.RangeCustomDTO;

@Component
public class ConvertModelToDTO {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    LogRepository logRepository;

    @Autowired
    AccountsRepository accountsRepository;

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

    public List<AccountsDTO> pageAccountModelToDTO(Page<AccountsModel> AccountsModels) {
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

    public LogDTO logModelToDto(LogModel logModel) {
        LogDTO logDTO = new LogDTO();
        logDTO.setLogin(logModel.getLogin());
        return logDTO;
    }

    // public AccountsDTO accountModelTDto(AccountsModel accountsModel) {
    // AccountsDTO accountsDTO = new AccountsDTO();
    // List<LogDTO> logDTOs = new ArrayList<>();
    // accountsDTO.setId(accountsModel.getId());
    // accountsDTO.setEmail(accountsModel.getEmail());
    // accountsDTO.setPassword(accountsModel.getPassword());
    // accountsDTO.setRegister(accountsModel.getRegister());
    // accountsDTO.setTotalLogin(logRepository
    // .countByCustomValue(accountsRepository
    // .findIdByEmail(accountsModel
    // .getEmail())));
    // // System.out.println(accountsModel.getLogs().toString());
    // accountsDTO.setLog(logDTOs);

    // for (LogModel logModel : accountsModel.getLogs()) {
    // logDTOs.add(logModelToDto(logModel));
    // }

    // return accountsDTO;
    // }

    public AccountsDTO rangeCustomDtoToAccountDto(RangeCustomDTO rangeCustomDTO) {

        return null;
    }

}
