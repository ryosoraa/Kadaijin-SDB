package com.kadaijin.kadaijin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.model.LogMain;
import com.kadaijin.kadaijin.repository.LogRepository;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public void logInsert(LogMain logModel) {
        this.logRepository.save(logModel);
    }

    public List<LogMain> getLog() {
        return this.logRepository.findAll();
    }

}
