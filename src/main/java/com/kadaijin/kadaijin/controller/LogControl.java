package com.kadaijin.kadaijin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kadaijin.kadaijin.model.log.LogMain;
import com.kadaijin.kadaijin.service.LogService;

@RestController
@RequestMapping("/log")
public class LogControl {

    @Autowired
    private LogService logService;

    @PostMapping
    private void postModel(LogMain logModel) {
        this.logService.logInsert(logModel);
    }

    @GetMapping
    private List<LogMain> getDataLog() {
        return this.logService.getLog();
    }

}
