package com.kadaijin.kadaijin.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.DTO.AccountsDTO;
import com.kadaijin.kadaijin.model.AccountsModel;
import com.kadaijin.kadaijin.repository.AccountsRepository;

@Service
public class GetService {

    @Autowired
    AccountsRepository AccountsRepository;

    @Autowired
    AccountsDTO accountsDTO;

    @Autowired
    ModelMapper modelMapper;

    public List<AccountsDTO> getData() {
        List<AccountsModel> findAll = AccountsRepository.findAll();

        return accountsDTO.listEntityToDto(findAll);
    }

    public AccountsDTO getOne(Integer no) {
        Optional<AccountsModel> optional = AccountsRepository.findById(no);
        AccountsDTO dto = modelMapper.map(optional, AccountsDTO.class);

        return dto;

    }

    public List<AccountsDTO> getPages(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size); // sistem untuk membaut paging
        Page<AccountsModel> pageResult = AccountsRepository.findAll(pageable);

        return accountsDTO.listEntityToDto(pageResult);
    }

}
