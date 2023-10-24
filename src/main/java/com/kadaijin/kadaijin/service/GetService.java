package com.kadaijin.kadaijin.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.model.DAO.AccountsModel;
import com.kadaijin.kadaijin.model.DTO.AccountsDTO;
import com.kadaijin.kadaijin.model.converter.ConvertModelToDTO;
import com.kadaijin.kadaijin.repository.AccountsRepository;
import com.kadaijin.kadaijin.repository.LogRepository;

@Service
public class GetService {

    @Autowired
    AccountsRepository AccountsRepository;

    @Autowired
    LogRepository logRepository;

    @Autowired
    AccountsDTO accountsDTO;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ConvertModelToDTO convertModelToDTO;

    public List<AccountsDTO> getData() {
        List<AccountsModel> findAll = AccountsRepository.findAll();

        return accountsDTO.listEntityToDto(findAll);
    }

    public AccountsDTO getOne(Integer no) {
        Optional<AccountsModel> optional = AccountsRepository.findById(no);
        // System.out.println(optional.get().toString());
        // AccountsDTO dto = modelMapper.map(optional, AccountsDTO.class);
        AccountsDTO dto = convertModelToDTO.accountModelToDto(optional.get());
        return dto;

    }

    public List<AccountsDTO> getPages(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size); // sistem untuk membaut paging
        Page<AccountsModel> pageResult = AccountsRepository.findAll(pageable);

        return accountsDTO.listEntityToDto(pageResult);
    }

}
