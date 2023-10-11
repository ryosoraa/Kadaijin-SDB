package com.kadaijin.kadaijin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.model.LogModel;
import com.kadaijin.kadaijin.repository.LogRepository;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public void logInsert(LogModel logModel) {
        this.logRepository.save(logModel);
    }

    public List<LogModel> getLog() {
        return this.logRepository.findAll();
    }

}
