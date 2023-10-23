package com.kadaijin.kadaijin.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.DTO.fiture.ConvertAccountsDTO;
import com.kadaijin.kadaijin.DTO.AccountsDTO;
import com.kadaijin.kadaijin.model.log.LogModel;
import com.kadaijin.kadaijin.model.AccountsModel;
import com.kadaijin.kadaijin.repository.log.LogRepository;
import com.kadaijin.kadaijin.repository.AccountsRepository;

import jakarta.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class LogService {

    @Autowired
    private AccountsRepository AccountsRepository;

    @Autowired
    private LogRepository logRepository;

    @Autowired
    EntityManager entityManager;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ConvertAccountsDTO convertAccountsDTO;

    public void logInsert(String username) {

        if (AccountsRepository.findByUsername(username) == null) {
            AccountsModel AccountsModel = new AccountsModel();
            AccountsModel.setEmail(username);
            AccountsRepository.save(AccountsModel);
        }

        Integer id = AccountsRepository.findIdByUsername(username);
        LogModel logModel = new LogModel(id);
        logRepository.save(logModel);

    }

    public List<AccountsDTO> getLog() {
        List<AccountsModel> AccountsModel = AccountsRepository.findAll();
        return convertAccountsDTO.listModelToDTO(AccountsModel);
    }

    public AccountsDTO getOneName(String request) {
        AccountsModel AccountsModel = AccountsRepository.findByUsername(request);
        return modelMapper.map(AccountsModel, AccountsDTO.class);

    }

    public List<AccountsDTO> getPage(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AccountsModel> pageResult = AccountsRepository.findAll(pageable);

        return convertAccountsDTO.listModelToDTO(pageResult);
    }
}
