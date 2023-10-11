package com.kadaijin.kadaijin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kadaijin.kadaijin.model.LogModel;
import com.kadaijin.kadaijin.repository.LogRepository;

@RestController
@RequestMapping("/log")
public class LogControl {

    @Autowired
    private LogRepository logRepository;

    @PostMapping
    private void postModel(LogModel logModel) {
        // this.logRepository.
    }

}
