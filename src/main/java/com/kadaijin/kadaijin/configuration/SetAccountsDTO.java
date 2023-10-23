package com.kadaijin.kadaijin.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kadaijin.kadaijin.DTO.AccountsDTO;
import com.kadaijin.kadaijin.DTO.fiture.ConvertModelToDTO;
import com.kadaijin.kadaijin.model.log.LogModel;
import com.kadaijin.kadaijin.repository.log.LogRepository;
import com.kadaijin.kadaijin.repository.AccountsRepository;

@Component
public class SetAccountsDTO {

    @Autowired
    ConvertModelToDTO convertModelToDTO;

    @Autowired
    LogRepository logRepository;

    @Autowired
    AccountsRepository AccountsRepository;

    public AccountsDTO setAccountsDTO(String email, List<LogModel> logModel) {
        AccountsDTO AccountsDTO = new AccountsDTO();
        AccountsDTO.setId(AccountsRepository.findIdByEmail(email));
        AccountsDTO.setEmail(email);
        AccountsDTO.setTotalLogin(logModel.size());
        AccountsDTO.setLog(convertModelToDTO.listModelToLogDTO(logModel));
        return AccountsDTO;
    }

    public AccountsDTO setAccountsDTO(List<LogModel> logModel) {
        AccountsDTO AccountsDTO = new AccountsDTO();
        AccountsDTO.setTotalLogin(logModel.size());
        AccountsDTO.setLog(convertModelToDTO.listModelToLogDTO(logModel));
        return AccountsDTO;
    }

}
