package com.kadaijin.kadaijin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kadaijin.kadaijin.model.DTO.AccountsDTO;
import com.kadaijin.kadaijin.model.DTO.LoginDTO;
import com.kadaijin.kadaijin.service.AccountsService;
import com.kadaijin.kadaijin.service.LogsService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/accounts")
public class Accounts {

    @Autowired
    LogsService logService;

    @Autowired
    AccountsService accountsService;

    @Operation(summary = "Register", description = "Register new user")
    @PostMapping("/Register")
    private void apiTest(@RequestBody AccountsDTO accountsDTO) {
        this.accountsService.insert(accountsDTO);

    }

    @Operation(summary = "Login", description = "Login user")
    @PostMapping("/Login")
    public void login(@RequestBody LoginDTO loginDTO) {
        this.accountsService.logInsert(loginDTO);

    }

    @Operation(summary = "Restore One Data", description = "returns data by id")
    @GetMapping("/get")
    private ResponseEntity<AccountsDTO> getDataOne(@RequestParam(defaultValue = "1") String id) {

        return ResponseEntity.ok()
                .body(accountsService.getOne(id));

    }

    @Operation(summary = "Restore All Data", description = "restore all saved data")
    @GetMapping("/get/all")
    private ResponseEntity<List<AccountsDTO>> getAllData() {

        return ResponseEntity.ok()
                .body(accountsService.getData());
    }

    @Operation(summary = "Returns data by page", description = "returns the desired amount of data")
    @GetMapping("/get/page")
    private ResponseEntity<List<AccountsDTO>> paging(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        return ResponseEntity.ok()
                .body(accountsService.getPages(page, size));
    }

}

/*
 *** ALTERNATIVE REGISTER**
 * 
 * @Operation(summary = "Alternative Register", description =
 * "Insert UserName And Password")
 * 
 * @PostMapping("/Register")
 * private void register(
 * 
 * @RequestParam String email,
 * 
 * @RequestParam String password) {
 * AccountsDTO accountsDTO = new AccountsDTO();
 * accountsDTO.setEmail(email);
 * accountsDTO.setPassword(password);
 * this.registerService.insert(accountsDTO);
 * }
 */

/*
 ** 
 * ALTERNATIVE LOGIN**
 * 
 * @Operation(summary = "Alternative login", description =
 * "Insert UserName And Password")
 * 
 * @PostMapping("/Login")
 * private void postEmail(
 * 
 * @RequestParam(name = "Email") String email,
 * 
 * @RequestParam(name = "Password") String password) {
 * AccountsDTO accountsDTO = new AccountsDTO();
 * accountsDTO.setEmail(email);
 * accountsDTO.setPassword(password);
 * this.logService.logInsert(accountsDTO);
 * ;
 * }
 */