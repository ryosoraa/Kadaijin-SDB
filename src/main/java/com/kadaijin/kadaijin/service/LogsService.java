package com.kadaijin.kadaijin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.kadaijin.kadaijin.repository.LogRepository;
import com.kadaijin.kadaijin.utils.Paging;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.model.DAO.AccountsModel;
import com.kadaijin.kadaijin.model.DAO.LogModel;
import com.kadaijin.kadaijin.model.DTO.AccountsDTO;
import com.kadaijin.kadaijin.model.DTO.RangeCustomDTO;
import com.kadaijin.kadaijin.utils.ConvertDTO;
import com.kadaijin.kadaijin.repository.AccountsRepository;
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
    private LogRepository logRepository;

    @Autowired
    private Paging paging;

    @Autowired
    PersonalDataRepository personalDataRepository;

    @Autowired
    EntityManager entityManager;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ConvertDTO convertDTO;

    // GET ALL ACCOUNTS AND DATA
    public List<AccountsDTO> getLog() {
        List<AccountsModel> AccountsModel = accountsRepository.findAll();
        return convertDTO.listAccountModelToDTO(AccountsModel);
    }

    // GET ONE ACCOUNT
    public AccountsDTO getOneName(String request) {
        try {
            Integer id = Integer.parseInt(request);
            Optional<AccountsModel> optional = accountsRepository.findById(id);
            return new AccountsDTO(optional.get());
        } catch (Exception e) {
            return new AccountsDTO(accountsRepository.findByEmails(request));
        }

    }

    // GET ACCOUNTS AND LOG WITH PAGE
    public List<AccountsDTO> getPage(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AccountsModel> pageResult = accountsRepository.findByPage(pageable);
        return convertDTO.listEntityToDto(pageResult);
    }

    // GET ACCOUNTS WITH LOGS CUSTOMIZE
    public AccountsDTO customize(RangeCustomDTO rangeCustomDTO) {
        List<LogModel> logModels = new ArrayList<>();
        AccountsModel accountsModel = accountsRepository.findByEmailAndLogBetweenDates(
                rangeCustomDTO.getEmail(),
                rangeCustomDTO.getStart(),
                rangeCustomDTO.getEnd());

            return new AccountsDTO(accountsModel, paging.page(rangeCustomDTO, accountsModel.getLogs()));

    }

}
