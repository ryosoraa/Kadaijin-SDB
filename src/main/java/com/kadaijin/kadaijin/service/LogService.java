package com.kadaijin.kadaijin.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.DTO.fiture.ConvertModelToDTO;
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
    private AccountsRepository accountsRepository;

    @Autowired
    private LogRepository logRepository;

    @Autowired
    EntityManager entityManager;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ConvertModelToDTO convertModelToDTO;

    public void logInsert(AccountsDTO accountsDTO) {
        if (accountsRepository.existsByEmailAndPassword(accountsDTO.getEmail(), accountsDTO.getPassword())) {
            System.out.println(accountsRepository.findIdByEmail(accountsDTO.getEmail()));
            LogModel logModel = new LogModel(accountsRepository.findIdByEmail(accountsDTO.getEmail()));
            logRepository.save(logModel);
            System.out.println("Masuk bang!");
        } else {
            System.out.println("ada yang salah bang!!");
        }


    }

    public List<AccountsDTO> getLog() {
        List<AccountsModel> AccountsModel = accountsRepository.findAll();
        return convertModelToDTO.listAccountModelToDTO(AccountsModel);
    }

    public AccountsDTO getOneName(String request) {
        AccountsModel AccountsModel = accountsRepository.findByEmail(request);
        return modelMapper.map(AccountsModel, AccountsDTO.class);

    }

    public List<AccountsDTO> getPage(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AccountsModel> pageResult = accountsRepository.findAll(pageable);

        return convertModelToDTO.pageAccountModelToDTO(pageResult);
    }
}
