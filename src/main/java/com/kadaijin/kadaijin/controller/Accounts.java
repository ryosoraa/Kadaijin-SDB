package com.kadaijin.kadaijin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kadaijin.kadaijin.DTO.KadaijinDTO;
import com.kadaijin.kadaijin.service.LoginService;
import com.kadaijin.kadaijin.service.RegisterService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/account")
public class Accounts {

    @Autowired
    LoginService loginService;

    @Autowired
    RegisterService registerService;

    @Operation(summary = "Alternative login", description = "Insert UserName And Password")
    @PostMapping("/Login")
    private void postEmail(
            @RequestParam(name = "Email") String email,
            @RequestParam(name = "Password") String password) {
        KadaijinDTO kadaijinDTO = new KadaijinDTO();
        kadaijinDTO.setUsername(email);
        kadaijinDTO.setPassword(password);
        this.loginService.newLogin(kadaijinDTO);
    }

    @Operation(summary = "Alternative Register", description = "Insert UserName And Password")
    @PostMapping("/Register")
    private void register(
            @RequestParam String email,
            @RequestParam String password) {
        KadaijinDTO kadaijinDTO = new KadaijinDTO();
        kadaijinDTO.setUsername(email);
        kadaijinDTO.setPassword(password);
        this.registerService.insert(kadaijinDTO);
    }

}
