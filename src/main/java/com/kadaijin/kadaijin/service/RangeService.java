package com.kadaijin.kadaijin.service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.DTO.AccountsDTO;
import com.kadaijin.kadaijin.DTO.RangeCustomDTO;
import com.kadaijin.kadaijin.DTO.fiture.ConvertModelToDTO;
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
    ConvertModelToDTO convertModelToDTO;

    @Autowired
    LogRepository logRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AccountsRepository accountsRepository;

    public AccountsDTO customize(String email, String starts, String finish) {

        AccountsModel AccountsModel = new AccountsModel(accountsRepository.findIdByEmail(email));
        Timestamp start = Timestamp.valueOf(starts.concat(" 00:00:00"));
        Timestamp end = Timestamp.valueOf(finish.concat(" 23:59:59"));
        List<LogModel> logModels = logRepository
                .findLogsBetweenLoginForUsers(start, end, AccountsModel);

        AccountsDTO AccountsDTO = setAccountsDTO.setAccountsDTO(email, logModels);
        return AccountsDTO;
    }

    public AccountsDTO restoreAll(String email) {
        AccountsDTO AccountsDTO = new AccountsDTO();
        AccountsModel AccountsModel = new AccountsModel(accountsRepository.findIdByEmail(email));
        List<LogModel> logModel = logRepository.findAllByAccounts_id(AccountsModel);

        AccountsDTO.setEmail(email);
        AccountsDTO.setLog(convertModelToDTO.listModelToLogDTO(logModel));
        AccountsDTO.setTotalLogin(logRepository.countByCustomValue(accountsRepository.findIdByEmail(email)));
        return AccountsDTO;
    }

    public AccountsDTO range(String email, String dates) {

        AccountsModel AccountsModel = new AccountsModel(accountsRepository.findIdByEmail(email));
        Timestamp start = Timestamp.valueOf(dates.concat(" 00:00:00"));
        Timestamp end = Timestamp.valueOf(dates.concat(" 23:59:59"));
        List<LogModel> logModels = logRepository
                .findLogsBetweenLoginForUsers(start, end, AccountsModel);

        AccountsDTO AccountsDTO = setAccountsDTO.setAccountsDTO(email, logModels);

        return AccountsDTO;

    }

    public AccountsDTO range(String email, String dates, String years) {

        AccountsModel AccountsModel = new AccountsModel(accountsRepository.findIdByEmail(email));
        Timestamp start = Timestamp.valueOf(years + "-" + dates.concat("-01 00:00:00"));
        Timestamp end = Timestamp.valueOf(years + "-" + dates.concat("-31 23:59:59"));
        List<LogModel> logModels = logRepository
                .findLogsBetweenLoginForUsers(start, end, AccountsModel);

        AccountsDTO AccountsDTO = setAccountsDTO.setAccountsDTO(email, logModels);

        return AccountsDTO;
    }

    public AccountsDTO rangeYears(String email, String years) {

        AccountsModel AccountsModel = new AccountsModel(accountsRepository.findIdByEmail(email));
        Timestamp start = Timestamp.valueOf(years + "-".concat("01-01 00:00:00"));
        Timestamp end = Timestamp.valueOf(years + "-".concat("12-31 23:59:59"));
        List<LogModel> logModels = logRepository
                .findLogsBetweenLoginForUsers(start, end, AccountsModel);

        AccountsDTO AccountsDTO = setAccountsDTO.setAccountsDTO(email, logModels);

        return AccountsDTO;
    }

    public List<AccountsDTO> customize(RangeCustomDTO rangeCustomDTO) {

        System.out.println(rangeCustomDTO.getStart());
        AccountsModel accountsModel = new AccountsModel(accountsRepository.findIdByEmail(rangeCustomDTO.getEmail()));
        System.out.println(rangeCustomDTO.getEnd());

        // Timestamp start = Timestamp.valueOf(rangeCustomDTO.getStart());
        // Timestamp finish = Timestamp.valueOf(rangeCustomDTO.getEnd());

        List<AccountsModel> accountsDTOs = accountsRepository
                .findByIdAndLog(accountsModel, rangeCustomDTO.getStart(), rangeCustomDTO.getEnd());

        return convertModelToDTO.listAccountModelToDTO(accountsDTOs);

    }

}
