package com.kadaijin.kadaijin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.model.KadaijinModel;
import com.kadaijin.kadaijin.repository.KadaijinRepository;

@Service
public class LoginService {

    @Autowired
    KadaijinRepository kadaijinRepository;

    public void cekLogin(KadaijinModel kadaijinModel) {

        KadaijinModel username = kadaijinRepository.findByusername(kadaijinModel.getUsername());
        KadaijinModel password = kadaijinRepository.findByPassword(kadaijinModel.getPassword());

        if (username != null && password != null) {
            System.out.println("Masuk bang!");
        } else {
            System.out.println("ada yang salah bang!!");
        }

    }
}
