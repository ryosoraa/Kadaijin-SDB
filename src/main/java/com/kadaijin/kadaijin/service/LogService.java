package com.kadaijin.kadaijin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.model.log.UserModel;
import com.kadaijin.kadaijin.repository.log.UserRepository;

@Service
public class LogService {

    @Autowired
    private UserRepository logRepository;

    public void logInsert(UserModel userModel) {
        this.logRepository.save(userModel);
    }

    public List<UserModel> getLog() {
        return this.logRepository.findAll();
    }

}
