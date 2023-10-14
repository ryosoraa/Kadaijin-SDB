package com.kadaijin.kadaijin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.model.log.LogModel;
import com.kadaijin.kadaijin.model.log.UserModel;
import com.kadaijin.kadaijin.repository.log.LogRepository;
import com.kadaijin.kadaijin.repository.log.UserRepository;

@Service
public class LogService {

    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private LogRepository logRepository;

    // @Autowired
    // private LogModel logModel;

    // public void logInsert(UserModel userModel) {

    // Long foreignKey = userRepository.findIDbyUsername(userModel.getUserName());
    // this.logModel.setUserID(foreignKey);
    // this.logRepository.save(logModel);
    // this.userRepository.save(userModel);

    // Long modelUser = userRepository.findIDbyUsername(userModel.getUserName());
    // Optional<UserModel> foreignUser = userRepository.findById(modelUser);
    // this.logModel.setUserModel(userModel);
    // this.logRepository.save(foreignUser);
    // this.userRepository.save(userModel);
    // }

    public List<UserModel> getLog() {
        return this.userRepository.findAll();
    }

}
