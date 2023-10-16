package com.kadaijin.kadaijin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kadaijin.kadaijin.DTO.KadaijinDTO;
import com.kadaijin.kadaijin.service.LoginService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/accounts")
public class Account {

    @Autowired
    LoginService loginService;

    @Operation(summary = "Alternative login", description = "Insert UserName And Password")
    @PostMapping("/login")
    private void postEmail(
            @RequestParam(name = "example@gmail.com") String name,
            @RequestParam(name = "password") String password) {
        KadaijinDTO kadaijinDTO = new KadaijinDTO();
        kadaijinDTO.setUsername(name);
        kadaijinDTO.setPassword(password);
        this.loginService.newLogin(kadaijinDTO);
    }
}
