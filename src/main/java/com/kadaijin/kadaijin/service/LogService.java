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

    public void logInsert(UserModel userModel) {

        Integer foreignKey = userRepository.findIdByUsername(userModel.getUserName());
        userRepository.save(userModel);

        // Buat instance LogModel
        LogModel logModel = new LogModel();
        logModel.setID(foreignKey);

        // Simpan LogModel
        logRepository.save(logModel);
    }

    public List<UserModel> getLog() {
        return this.userRepository.findAll();
    }
}
