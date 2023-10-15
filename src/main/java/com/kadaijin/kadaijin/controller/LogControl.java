package com.kadaijin.kadaijin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kadaijin.kadaijin.DTO.KadaijinDTO;
import com.kadaijin.kadaijin.DTO.log.UserDTO;
import com.kadaijin.kadaijin.model.KadaijinModel;
import com.kadaijin.kadaijin.model.log.UserModel;
import com.kadaijin.kadaijin.repository.KadaijinRepository;
import com.kadaijin.kadaijin.service.LogService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/log")
public class LogControl {

    @Autowired
    private LogService logService;

    @Autowired
    KadaijinRepository kadaijinRepository;

    @Operation(summary = "Post Data", description = "Post Data Json")
    @PostMapping
    private void postModel(@RequestBody UserModel userModel) {
        this.logService.logInsert(userModel);
        System.out.println(userModel.toString());
    }

    @Operation(summary = "Alternative login", description = "Insert UserName And Password")
    @PostMapping("/email")
    private void postEmail(@RequestParam String email) {
        UserModel userModel = new UserModel();
        userModel.setUserName(email);
        this.logService.logInsert(userModel);
    }

    @Operation(summary = "Restore All Data", description = "restore all saved data")
    @GetMapping("/all")
    private List<UserDTO> getDataLog() {
        return this.logService.getLog();
    }

    @Operation(summary = "Get Data Log", description = "view login log via email name")
    @GetMapping
    private UserDTO getOne(@RequestParam String request) {
        return this.logService.getOneName(request);
    }

    @Operation(summary = "Returns Email And Log", description = "restore email data and login logs with page")
    @GetMapping("/page")
    private List<UserDTO> getPage(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        return logService.getPage(page, size);
    }

}
