package com.kadaijin.kadaijin.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.model.DAO.AccountsModel;
import com.kadaijin.kadaijin.model.DTO.AccountsDTO;
import com.kadaijin.kadaijin.repository.AccountsRepository;

@Service
public class AccountsService {

    @Autowired
    AccountsRepository accountsRepository;

    @Autowired
    ModelMapper modelMapper;

    public void insert(AccountsDTO accountsDTO) {

        if (accountsRepository.findByEmail(accountsDTO.getEmail()) != null) {
            System.out.println("Email udah ada bang!!");
        } else {
            AccountsModel model = modelMapper.map(accountsDTO, AccountsModel.class);
            this.accountsRepository.save(model);
        }
    }
}
