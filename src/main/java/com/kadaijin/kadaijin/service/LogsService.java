package com.kadaijin.kadaijin.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.model.DAO.AccountsModel;
import com.kadaijin.kadaijin.model.DAO.LogModel;
import com.kadaijin.kadaijin.model.DTO.AccountsDTO;
import com.kadaijin.kadaijin.model.DTO.RangeCustomDTO;
import com.kadaijin.kadaijin.model.converter.ConvertDTO;
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
            AccountsDTO dto = new AccountsDTO(optional.get());
            return dto;
        } catch (Exception e) {
            AccountsDTO accountsDTO = new AccountsDTO(accountsRepository.findByEmails(request));
            return accountsDTO;
        }

    }

    // GET ACCOUNTS AND LOG WITH PAGE
    public List<AccountsDTO> getPage(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AccountsModel> pageResult = accountsRepository.findByPage(pageable);
        return convertDTO.listEntityToDto(pageResult);
    }

    // GET ACCOUNTS WITH LOGS CUSTOMIZE
    public AccountsDTO customsize(RangeCustomDTO rangeCustomDTO) {
        List<LogModel> logModels = new ArrayList<>();
        AccountsModel accountsModel = accountsRepository.findByEmailAndLogBetweenDates(
                rangeCustomDTO.getEmail(),
                rangeCustomDTO.getStart(),
                rangeCustomDTO.getEnd());

        System.out.println(accountsModel.getLogs().size());

        // return new AccountsDTO(accountsModel);

        try {
            for (LogModel logModel : accountsModel.getLogs()) {
                if (logModel.getLogin().after(rangeCustomDTO.getStart())
                        &&
                        logModel.getLogin().before(rangeCustomDTO.getEnd())) {
                    logModels.add(logModel);
                }
            }
            {
                int size = rangeCustomDTO.getSize();
                int page = rangeCustomDTO.getPage() * size;
                List<LogModel> subList = logModels.subList(page, page + size);
                return new AccountsDTO(accountsModel, new ArrayList<>(subList));
            }
        } catch (Exception e) {
            return new AccountsDTO(accountsRepository.findByEmails(rangeCustomDTO.getEmail()),
                    Collections.EMPTY_LIST);
        }

    }

}

/*
 * int size = rangeCustomDTO.getSize();
 * int page = rangeCustomDTO.getPage() * rangeCustomDTO.getSize();
 * for (int i = 0; i < size; i++) {
 * results.add(logModels.get(page + i));
 * }
 * return new AccountsDTO(accountsModel, results)
 */
