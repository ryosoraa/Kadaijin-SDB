package com.kadaijin.kadaijin.service;

import java.sql.Timestamp;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.DTO.fiture.ConvertAccountsDTO;
import com.kadaijin.kadaijin.DTO.AccountsDTO;
import com.kadaijin.kadaijin.configuration.SetAccountsDTO;
import com.kadaijin.kadaijin.model.log.LogModel;
import com.kadaijin.kadaijin.model.AccountsModel;
import com.kadaijin.kadaijin.repository.log.LogRepository;
import com.kadaijin.kadaijin.repository.AccountsRepository;

@Service
public class RangeService {

    @Autowired
    SetAccountsDTO setAccountsDTO;

    @Autowired
    ConvertAccountsDTO convertAccountsDTO;

    @Autowired
    LogRepository logRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AccountsRepository AccountsRepository;

    public AccountsDTO customize(String email, String starts, String finish) {

        AccountsModel AccountsModel = new AccountsModel(AccountsRepository.findIdByEmail(email));
        Timestamp start = Timestamp.valueOf(starts.concat(" 00:00:00"));
        Timestamp end = Timestamp.valueOf(finish.concat(" 23:59:59"));
        List<LogModel> logModels = logRepository
                .findLogsBetweenLoginForUsers(start, end, AccountsModel);

        AccountsDTO AccountsDTO = setAccountsDTO.setAccountsDTO(email, logModels);
        return AccountsDTO;
    }

    public AccountsDTO restoreAll(String email) {
        AccountsDTO AccountsDTO = new AccountsDTO();
        AccountsModel AccountsModel = new AccountsModel(AccountsRepository.findIdByEmail(email));
        List<LogModel> logModel = logRepository.findAllByAccount_id(AccountsModel);

        AccountsDTO.setUsername(email);
        AccountsDTO.setLog(convertAccountsDTO.listModelToLogDTO(logModel));
        AccountsDTO.setTotalLogin(logRepository.countByCustomValue(AccountsRepository.findIdByEmail(email)));
        return AccountsDTO;
    }

    public AccountsDTO range(String email, String dates) {

        AccountsModel AccountsModel = new AccountsModel(AccountsRepository.findIdByEmail(email));
        Timestamp start = Timestamp.valueOf(dates.concat(" 00:00:00"));
        Timestamp end = Timestamp.valueOf(dates.concat(" 23:59:59"));
        List<LogModel> logModels = logRepository
                .findLogsBetweenLoginForUsers(start, end, AccountsModel);

        AccountsDTO AccountsDTO = setAccountsDTO.setAccountsDTO(email, logModels);

        return AccountsDTO;

    }

    public AccountsDTO range(String email, String dates, String years) {

        AccountsModel AccountsModel = new AccountsModel(AccountsRepository.findIdByEmail(email));
        Timestamp start = Timestamp.valueOf(years + "-" + dates.concat("-01 00:00:00"));
        Timestamp end = Timestamp.valueOf(years + "-" + dates.concat("-31 23:59:59"));
        List<LogModel> logModels = logRepository
                .findLogsBetweenLoginForUsers(start, end, AccountsModel);

        AccountsDTO AccountsDTO = setAccountsDTO.setAccountsDTO(email, logModels);

        return AccountsDTO;
    }

    public AccountsDTO rangeYears(String email, String years) {

        AccountsModel AccountsModel = new AccountsModel(AccountsRepository.findIdByEmail(email));
        Timestamp start = Timestamp.valueOf(years + "-".concat("01-01 00:00:00"));
        Timestamp end = Timestamp.valueOf(years + "-".concat("12-31 23:59:59"));
        List<LogModel> logModels = logRepository
                .findLogsBetweenLoginForUsers(start, end, AccountsModel);

        AccountsDTO AccountsDTO = setAccountsDTO.setAccountsDTO(email, logModels);

        return AccountsDTO;
    }

}
