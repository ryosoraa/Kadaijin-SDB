package com.kadaijin.kadaijin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.DTO.AccountsDTO;
import com.kadaijin.kadaijin.repository.AccountsRepository;

@Service
public class LoginService {

    @Autowired
    AccountsRepository AccountsRepository;

    @Autowired
    LogService logService;

    public void newLogin(AccountsDTO accountsDTO) {

        if (AccountsRepository.existsByEmailAndPassword(accountsDTO.getUsername(), accountsDTO.getPassword())) {
            logService.logInsert(accountsDTO.getUsername());
            System.out.println("Masuk bang!");
        } else {
            System.out.println("ada yang salah bang!!");
        }

    }

}
