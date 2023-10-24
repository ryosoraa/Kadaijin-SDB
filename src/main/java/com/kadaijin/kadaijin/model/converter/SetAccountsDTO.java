package com.kadaijin.kadaijin.model.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kadaijin.kadaijin.model.DAO.LogModel;
import com.kadaijin.kadaijin.model.DTO.AccountsDTO;
import com.kadaijin.kadaijin.repository.AccountsRepository;
import com.kadaijin.kadaijin.repository.LogRepository;

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
        AccountsDTO.setLog(logModel);
        return AccountsDTO;
    }

}
