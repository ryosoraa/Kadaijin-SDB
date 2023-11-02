package com.kadaijin.kadaijin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kadaijin.kadaijin.model.DTO.AccountsDTO;
import com.kadaijin.kadaijin.model.DTO.RangeCustomDTO;
import com.kadaijin.kadaijin.payload.ResponseHandler;
import com.kadaijin.kadaijin.repository.AccountsRepository;
import com.kadaijin.kadaijin.service.AccountsService;
import com.kadaijin.kadaijin.service.LogsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/logs")
public class Logs {

    @Autowired
    private LogsService logService;

    @Autowired
    AccountsService accountsService;

    @Autowired
    AccountsRepository AccountsRepository;

    @Operation(summary = "Get Data Log", description = "You can get data via ID or email")
    @GetMapping
    private ResponseEntity<Object> getOne(
            @RequestParam(name = "Request", defaultValue = "ryo@gmail.com") String request) {
        try {
            AccountsDTO accountsDTO = logService.getOneName(request);
            return ResponseHandler.generateResponse("Successfully return data!", HttpStatus.OK, accountsDTO);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @Operation(summary = "Returns data by page", description = "restore email data and login logs with page")
    @GetMapping("/page")
    private ResponseEntity<Object> getPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {

        try {
            return ResponseHandler.generateResponse("Succesfully return data", HttpStatus.OK, logService.getPage(page -1, size));
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @Operation(summary = "Restore Data Customize", description = "returns data by Customize date")
    @GetMapping("/customize")
    private ResponseEntity<Object> experiment(@RequestBody RangeCustomDTO rangeCustomDTO) {
        System.out.println(rangeCustomDTO.getEmail());

        try {
            return ResponseHandler.generateResponse("Succesfully return data", HttpStatus.OK, logService.customsize(rangeCustomDTO));
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
