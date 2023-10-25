package com.kadaijin.kadaijin.service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.model.DAO.AccountsModel;
import com.kadaijin.kadaijin.model.DAO.LogModel;
import com.kadaijin.kadaijin.model.DAO.PersonalDataModel;
import com.kadaijin.kadaijin.model.DTO.AccountsDTO;
import com.kadaijin.kadaijin.model.DTO.PersonalDataDTO;
import com.kadaijin.kadaijin.model.DTO.RangeCustomDTO;
import com.kadaijin.kadaijin.model.converter.ConvertModelToDTO;
import com.kadaijin.kadaijin.model.converter.SetAccountsDTO;
import com.kadaijin.kadaijin.repository.AccountsRepository;
import com.kadaijin.kadaijin.repository.LogRepository;
import com.kadaijin.kadaijin.repository.PersonalDataRepository;

@Service
public class RangeService {

    @Autowired
    SetAccountsDTO setAccountsDTO;

    @Autowired
    LogRepository logRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AccountsRepository accountsRepository;

    @Autowired
    PersonalDataRepository personalDataRepository;

    public AccountsDTO customize(String email, String starts, String finish) {

        AccountsModel AccountsModel = new AccountsModel(accountsRepository.findIdByEmail(email));
        Timestamp start = Timestamp.valueOf(starts.concat(" 00:00:00"));
        Timestamp end = Timestamp.valueOf(finish.concat(" 23:59:59"));
        List<LogModel> logModels = logRepository
                .findLogsBetweenLoginForUsers(start, end, AccountsModel);

        AccountsDTO AccountsDTO = setAccountsDTO.setAccountsDTO(email, logModels);
        return AccountsDTO;
    }

    // ================================================================================

    // public AccountsDTO customize(RangeCustomDTO rangeCustomDTO) {

    // AccountsModel accountsModels = accountsRepository
    // .findByEmailAndLog(
    // rangeCustomDTO.getEmail(),
    // rangeCustomDTO.getStart(),
    // rangeCustomDTO.getEnd());

    // if (accountsModels != null) {
    // System.out.println("data bang!!");
    // } else {
    // System.out.println("Data tidak ditemukan.");
    // System.out.println(rangeCustomDTO.getEmail());
    // System.out.println(rangeCustomDTO.getStart());
    // System.out.println(rangeCustomDTO.getEnd());
    // }

    // return new AccountsDTO(accountsModels);

    // }

    public PersonalDataDTO getByName(String name) {
        PersonalDataModel personalDataModel = personalDataRepository.findByJeneng(name);

        if (personalDataModel == null) {
            System.out.println("Kosong bang!!");
        }

        return new PersonalDataDTO(personalDataModel, 1);

    }

    public AccountsDTO customsize(String email, String start, String end) {

        if (start == null || end == null) {
            return new AccountsDTO(accountsRepository.findByEmail(email));
        } else {

            List<LogModel> logModels = new ArrayList<>();
            RangeCustomDTO rangeCustomDTO = new RangeCustomDTO(email, start, end);

            AccountsModel accountsModel = accountsRepository.findByEmailAndLog(
                    rangeCustomDTO.getEmail(),
                    rangeCustomDTO.getStart(),
                    rangeCustomDTO.getEnd());

            for (LogModel logModel : accountsModel.getLogs()) {
                if (logModel.getLogin().after(rangeCustomDTO.getStart())
                        && logModel.getLogin().before(rangeCustomDTO.getEnd())) {
                    logModels.add(logModel);
                }
            }

            return new AccountsDTO(accountsModel, logModels);
        }

    }

}
