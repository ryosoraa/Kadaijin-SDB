package com.kadaijin.kadaijin.service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.model.DAO.AccountsModel;
import com.kadaijin.kadaijin.model.DAO.LogModel;
import com.kadaijin.kadaijin.model.DTO.AccountsDTO;
import com.kadaijin.kadaijin.model.DTO.RangeCustomDTO;
import com.kadaijin.kadaijin.model.converter.ConvertModelToDTO;
import com.kadaijin.kadaijin.model.converter.SetAccountsDTO;
import com.kadaijin.kadaijin.repository.AccountsRepository;
import com.kadaijin.kadaijin.repository.LogRepository;

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

    // ================================================================================

    public AccountsModel customize(RangeCustomDTO rangeCustomDTO) {

        AccountsModel accountsModels = accountsRepository
                .findByIdAndLogsInDateRange(accountsRepository.findIdByEmail(
                        rangeCustomDTO.getEmail()),
                        rangeCustomDTO.getStart(),
                        rangeCustomDTO.getEnd());

        if (accountsModels != null) {
            System.out.println("data bang!!");
        } else {
            System.out.println("Data tidak ditemukan.");
            System.out.println(rangeCustomDTO.getEmail());
            System.out.println(rangeCustomDTO.getStart());
            System.out.println(rangeCustomDTO.getEnd());
        }

        return accountsModels;

    }

    public List<AccountsDTO> ranges(String dates) {

        Timestamp start = Timestamp.valueOf(dates.concat(" 02:49:15"));
        Timestamp end = Timestamp.valueOf(dates.concat(" 02:49:15"));

        List<AccountsModel> AccountsModel = accountsRepository.findAccountsModelAndLogs(start, end);

        List<AccountsDTO> AccountsDTO = convertModelToDTO.listAccountModelToDTO(AccountsModel);

        return AccountsDTO;

    }

}
