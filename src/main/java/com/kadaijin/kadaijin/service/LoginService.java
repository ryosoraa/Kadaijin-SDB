package com.kadaijin.kadaijin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.model.KadaijinModel;
import com.kadaijin.kadaijin.model.log.LogModel;
import com.kadaijin.kadaijin.model.log.UserModel;
import com.kadaijin.kadaijin.repository.KadaijinRepository;
import com.kadaijin.kadaijin.repository.log.LogRepository;
import com.kadaijin.kadaijin.repository.log.UserRepository;

@Service
public class LoginService {

    @Autowired
    KadaijinRepository kadaijinRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    LogRepository logRepository;

    @Autowired
    UserModel userModel;

    public void cekLogin(KadaijinModel kadaijinModel) {

        KadaijinModel username = kadaijinRepository.findByusername(kadaijinModel.getUsername());
        KadaijinModel password = kadaijinRepository.findByPassword(kadaijinModel.getPassword());

        if (username != null && password != null) {
            System.out.println("Masuk bang!");
        } else {
            System.out.println("ada yang salah bang!!");
        }

    }

    public void logLogin(KadaijinModel kadaijinModel) {
        KadaijinModel username = kadaijinRepository.findByusername(kadaijinModel.getUsername());
        KadaijinModel password = kadaijinRepository.findByPassword(kadaijinModel.getPassword());

        if (username != null && password != null) {

            if (userRepository.findUsername(kadaijinModel.getUsername()) != null) {

                // Mengatur userName model dengan username yang di kirimkan
                this.userModel.setUserName(kadaijinModel.getUsername());

                // Mencari Tahu ada berapa banyak nama dari repository (Database)
                this.userModel.setTotalLogin(logRepository.count(kadaijinModel.getUsername()));

                this.userRepository.save(this.userModel);
            }
        }
    }
}
