package com.kadaijin.kadaijin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.model.KadaijinModel;
import com.kadaijin.kadaijin.model.log.LogModel;
import com.kadaijin.kadaijin.model.log.UserModel;
import com.kadaijin.kadaijin.repository.KadaijinRepository;
import com.kadaijin.kadaijin.repository.LogRepository;

@Service
public class LoginService {

    @Autowired
    KadaijinRepository kadaijinRepository;

    @Autowired
    LogRepository logRepository;

    public void cekLogin(KadaijinModel kadaijinModel) {

        KadaijinModel username = kadaijinRepository.findByusername(kadaijinModel.getUsername());
        KadaijinModel password = kadaijinRepository.findByPassword(kadaijinModel.getPassword());

        if (username != null && password != null) {
            System.out.println("Masuk bang!");
        } else {
            System.out.println("ada yang salah bang!!");
        }

    }

    public void logLogin(KadaijinModel kadaijinModel, UserModel userModel) {
        KadaijinModel username = kadaijinRepository.findByusername(kadaijinModel.getUsername());
        KadaijinModel password = kadaijinRepository.findByPassword(kadaijinModel.getPassword());

        if (username != null && password != null) {
            this.logRepository.save(userModel);
        }
    }
}
