package com.kadaijin.kadaijin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.model.KadaijinModel;
import com.kadaijin.kadaijin.model.log.LogModel;
import com.kadaijin.kadaijin.model.log.UserModel;
import com.kadaijin.kadaijin.repository.log.LogRepository;
import com.kadaijin.kadaijin.repository.log.UserRepository;

@Service
public class LogService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private LogModel logModel;

    public void logInsert(UserModel userModel) {

        Long foreignKey = userRepository.findIdByUsername(userModel.getUserName());
        this.userRepository.save(userModel);

        this.logModel.setID(foreignKey);
        this.logRepository.save(logModel);

        // Long modelUser = userRepository.findIDbyUsername(userModel.getUserName());
        // Optional<UserModel> foreignUser = userRepository.findById(modelUser);
        // this.logModel.setUserModel(userModel);
        // this.logRepository.save(foreignUser);
        // this.userRepository.save(userModel);
    }

    public List<UserModel> getLog() {
        return this.userRepository.findAll();
    }

    // public void tryInsert(UserModel userModel) {

    // userRepository.save(userModel);
    // List<LogModel> logModels = userModel.getLog();
    // for (LogModel log : userModel.getLog()) {
    // log.setUserModel(logModels); // Setel pengguna untuk setiap entitas Log
    // logRepository.save(log); // Simpan Log ke database
    // }
    // userRepository.save(userModel);
    // }

}
