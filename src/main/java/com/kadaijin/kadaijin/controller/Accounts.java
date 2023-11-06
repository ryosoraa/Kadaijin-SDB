package com.kadaijin.kadaijin.controller;

import com.kadaijin.kadaijin.model.DTO.RegisterDTO;
import com.kadaijin.kadaijin.payload.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
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

    @PostMapping("/Register")
    public void register(@RequestBody RegisterDTO registerDTO){
        System.out.println(registerDTO.getEmail());
        this.accountsService.insert(registerDTO);
    }

    @Operation(summary = "Login", description = "Login user")
    @PostMapping("/Login")
    public void login(@RequestBody LoginDTO loginDTO) {
        this.accountsService.logInsert(loginDTO);

    }

    @Operation(summary = "Restore One Data", description = "You can search for data via ID or email")
    @GetMapping("/get")
    private ResponseEntity<Object> getDataOne(@RequestParam(name = "Request", defaultValue = "1") String request) {

        try {
            return ResponseHandler.generateResponse("Successfully return data!", HttpStatus.OK, accountsService.getOne(request));

        } catch (Exception e) {

            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }

    @Operation(summary = "Restore All Data", description = "restore all saved data")
    @GetMapping("/get/all")
    private ResponseEntity<Object> getAllData() {

        try {
            return ResponseHandler.generateResponse("Successfully return data!", HttpStatus.OK, accountsService.getData());
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @Operation(summary = "Returns data by page", description = "returns the desired amount of data")
    @GetMapping("/get/page")
    private ResponseEntity<Object> paging(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        try {
            return ResponseHandler.generateResponse("Successfully return data!", HttpStatus.OK, accountsService.getPages(page, size));
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
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