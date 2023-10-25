package com.kadaijin.kadaijin.service;

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
import com.kadaijin.kadaijin.model.converter.ConvertDTO;
import com.kadaijin.kadaijin.repository.AccountsRepository;
import com.kadaijin.kadaijin.repository.LogRepository;
import com.kadaijin.kadaijin.repository.PersonalDataRepository;

import jakarta.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class LogsService {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    PersonalDataRepository personalDataRepository;

    @Autowired
    private LogRepository logRepository;

    @Autowired
    EntityManager entityManager;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ConvertDTO convertDTO;

    public List<AccountsDTO> getLog() {
        List<AccountsModel> AccountsModel = accountsRepository.findAll();
        return convertDTO.listAccountModelToDTO(AccountsModel);
    }

    public AccountsDTO getOneName(String request) {
        AccountsModel AccountsModel = accountsRepository.findByEmails(request);
        return modelMapper.map(AccountsModel, AccountsDTO.class);

    }

    public List<AccountsDTO> getPage(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AccountsModel> pageResult = accountsRepository.findEmailAndLogBypage(pageable);

        return convertDTO.listEntityToDto(pageResult);
    }

    public AccountsDTO getOne(Integer no) {
        Optional<AccountsModel> optional = accountsRepository.findById(no);
        AccountsDTO dto = new AccountsDTO(optional.get());
        return dto;

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
