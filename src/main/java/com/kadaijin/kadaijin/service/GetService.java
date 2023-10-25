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


}
