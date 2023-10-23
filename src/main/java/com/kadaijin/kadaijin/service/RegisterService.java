package com.kadaijin.kadaijin.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.DTO.AccountsDTO;
import com.kadaijin.kadaijin.model.AccountsModel;
import com.kadaijin.kadaijin.repository.AccountsRepository;

@Service
public class RegisterService {

    @Autowired
    AccountsRepository AccountsRepository;

    @Autowired
    ModelMapper modelMapper;

    public void insert(AccountsDTO accountsDTO) {

        /**
         * menyimpan data yang di ambil lalu di masukan di dalam model
         * setelah di masukan kedalam model lalu di save kedalam repository yang
         * terhubung
         * dengan databasenya
         */

        if (AccountsRepository.findByEmail(accountsDTO.getUsername()) != null) {
            System.out.println("Email udah ada bang!!");
        } else {
            AccountsModel model = modelMapper.map(accountsDTO, AccountsModel.class);
            this.AccountsRepository.save(model);
        }
    }

}
