package com.kadaijin.kadaijin.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.DTO.KadaijinDTO;
import com.kadaijin.kadaijin.model.AccountsModel;
import com.kadaijin.kadaijin.repository.KadaijinRepository;

@Service
public class RegisterService {

    @Autowired
    KadaijinRepository kadaijinRepository;

    @Autowired
    ModelMapper modelMapper;

    public void insert(KadaijinDTO kadaijinDTO) {

        /**
         * menyimpan data yang di ambil lalu di masukan di dalam model
         * setelah di masukan kedalam model lalu di save kedalam repository yang
         * terhubung
         * dengan databasenya
         */

        if (kadaijinRepository.findByUsername(kadaijinDTO.getUsername()) != null) {
            System.out.println("Email udah ada bang!!");
        } else {
            AccountsModel model = modelMapper.map(kadaijinDTO, AccountsModel.class);
            this.kadaijinRepository.save(model);
        }
    }

}
