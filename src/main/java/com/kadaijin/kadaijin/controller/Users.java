package com.kadaijin.kadaijin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kadaijin.kadaijin.DTO.AccountsDTO;
import com.kadaijin.kadaijin.service.GetService;
import com.kadaijin.kadaijin.service.LogService;
import com.kadaijin.kadaijin.service.RegisterService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/users")
public class Users {

    @Autowired // seperti saling terkoneksi dengan yang di path service
    private RegisterService registerService;

    @Autowired
    private LogService logService;

    @Autowired
    private GetService getService;

    @Operation(summary = "Register", description = "Register new user")
    @PostMapping("/Register")
    private void apiTest(@RequestBody AccountsDTO accountsDTO) {
        System.out.println("register : " + accountsDTO.toString());
        this.registerService.insert(accountsDTO);

    }

    @Operation(summary = "Login", description = "Login user")
    @PostMapping("/Login")
    public void login(@RequestBody AccountsDTO accountsDTO) {
        this.logService.logInsert(accountsDTO);

    }

    @Operation(summary = "Restore One Data", description = "returns data by id")
    @GetMapping("/get")
    private AccountsDTO getDataOne(@RequestParam(defaultValue = "1") Integer id) {
        return this.getService.getOne(id);

    }

    @Operation(summary = "Restore All Data", description = "restore all saved data")
    @GetMapping("/get/all")
    private List<AccountsDTO> getAllData() {
        return this.getService.getData();
    }

    @Operation(summary = "Returns data by page", description = "returns the desired amount of data")
    @GetMapping("/get/page")
    private List<AccountsDTO> paging(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        List<AccountsDTO> kadaijinList = getService.getPages(page, size);
        return kadaijinList;
    }

}
