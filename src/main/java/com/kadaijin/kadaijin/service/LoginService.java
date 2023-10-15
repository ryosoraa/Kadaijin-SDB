package com.kadaijin.kadaijin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.DTO.KadaijinDTO;
import com.kadaijin.kadaijin.model.KadaijinModel;
import com.kadaijin.kadaijin.model.log.LogModel;
import com.kadaijin.kadaijin.model.log.UserModel;
import com.kadaijin.kadaijin.repository.KadaijinRepository;
// import com.kadaijin.kadaijin.repository.log.LogRepository;
// import com.kadaijin.kadaijin.repository.log.UserRepository;

@Service
public class LoginService {

    @Autowired
    KadaijinRepository kadaijinRepository;

    @Autowired
    LogService logService;

    public void cekLogin(KadaijinDTO kadaijinDTO) {

        if (kadaijinRepository.existsByUsernameAndPassword(kadaijinDTO.getUsername(), kadaijinDTO.getPassword())) {
            UserModel userModel = new UserModel();
            userModel.setUserName(kadaijinDTO.getUsername());
            logService.logInsert(userModel);
            System.out.println("Masuk bang!");
        } else {
            System.out.println("ada yang salah bang!!");
        }

    }

}
