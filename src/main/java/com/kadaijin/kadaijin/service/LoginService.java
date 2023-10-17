package com.kadaijin.kadaijin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.DTO.KadaijinDTO;
import com.kadaijin.kadaijin.model.log.UserModel;
import com.kadaijin.kadaijin.repository.KadaijinRepository;

@Service
public class LoginService {

    @Autowired
    KadaijinRepository kadaijinRepository;

    @Autowired
    LogService logService;

    public void newLogin(KadaijinDTO kadaijinDTO) {

        if (kadaijinRepository.existsByUsernameAndPassword(kadaijinDTO.getUsername(), kadaijinDTO.getPassword())) {
            UserModel userModel = new UserModel();
            userModel.setUserName(kadaijinDTO.getUsername());
            logService.logInsert(userModel.getUserName());
            System.out.println("Masuk bang!");
        } else {
            System.out.println("ada yang salah bang!!");
        }

    }

}
