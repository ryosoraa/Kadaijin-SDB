package com.kadaijin.kadaijin.model.converter;

import org.springframework.beans.factory.annotation.Autowired;

import com.kadaijin.kadaijin.model.DAO.AccountsModel;
import com.kadaijin.kadaijin.model.DTO.RangeCustomDTO;
import com.kadaijin.kadaijin.repository.AccountsRepository;

public class CovertDtoToModel {

    @Autowired
    AccountsRepository accountsRepository;

    public AccountsModel rangeCustomDTOtoAccountModel(RangeCustomDTO rangeCustomDTO) {
        AccountsModel accountsModel = new AccountsModel();
        accountsModel.setEmail(rangeCustomDTO.getEmail());
        accountsModel.setId(accountsRepository.findIdByEmail(rangeCustomDTO.getEmail()));
        return accountsModel;

    }
}
