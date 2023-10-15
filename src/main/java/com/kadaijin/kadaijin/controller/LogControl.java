package com.kadaijin.kadaijin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kadaijin.kadaijin.DTO.log.UserDTO;
import com.kadaijin.kadaijin.model.log.UserModel;
import com.kadaijin.kadaijin.service.LogService;

@RestController
@RequestMapping("/log")
public class LogControl {

    @Autowired
    private LogService logService;

    @PostMapping
    private void postModel(@RequestBody UserModel userModel) {
        this.logService.logInsert(userModel);
        System.out.println(userModel.toString());
    }

    @GetMapping("/all")
    private List<UserDTO> getDataLog() {
        return this.logService.getLog();
    }

    @GetMapping
    private UserDTO getOne(@RequestParam String request) {
        return this.logService.getOneName(request);
    }

}
