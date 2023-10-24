package com.kadaijin.kadaijin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kadaijin.kadaijin.DTO.AccountsDTO;
import com.kadaijin.kadaijin.service.LogService;
import com.kadaijin.kadaijin.service.RegisterService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/account")
public class Accounts {

    @Autowired
    LogService logService;

    @Autowired
    RegisterService registerService;

    @Operation(summary = "Alternative login", description = "Insert UserName And Password")
    @PostMapping("/Login")
    private void postEmail(
            @RequestParam(name = "Email") String email,
            @RequestParam(name = "Password") String password) {
        AccountsDTO accountsDTO = new AccountsDTO();
        accountsDTO.setEmail(email);
        accountsDTO.setPassword(password);
        this.logService.logInsert(accountsDTO);
        ;
    }

    @Operation(summary = "Alternative Register", description = "Insert UserName And Password")
    @PostMapping("/Register")
    private void register(
            @RequestParam String email,
            @RequestParam String password) {
        AccountsDTO accountsDTO = new AccountsDTO();
        accountsDTO.setEmail(email);
        accountsDTO.setPassword(password);
        this.registerService.insert(accountsDTO);
    }

}
