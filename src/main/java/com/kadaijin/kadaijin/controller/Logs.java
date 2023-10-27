package com.kadaijin.kadaijin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kadaijin.kadaijin.model.DTO.AccountsDTO;
import com.kadaijin.kadaijin.model.DTO.RangeCustomDTO;
import com.kadaijin.kadaijin.repository.AccountsRepository;
import com.kadaijin.kadaijin.service.AccountsService;
import com.kadaijin.kadaijin.service.LogsService;

import io.swagger.v3.oas.annotations.Operation;

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
    private ResponseEntity<AccountsDTO> getOne(
            @RequestParam(name = "Request", defaultValue = "ryo@gmail.com") String request) {
        return ResponseEntity.ok()
                .body(logService.getOneName(request));

    }

    @Operation(summary = "Returns data by page", description = "restore email data and login logs with page")
    @GetMapping("/page")
    private ResponseEntity<List<AccountsDTO>> getPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        return ResponseEntity.badRequest()
                .body(logService.getPage(page - 1, size));
    }

    @Operation(summary = "Restore Data Customize", description = "returns data by Customize date")
    @GetMapping("/customs")
    public AccountsDTO customs(
            @RequestParam(name = "email", defaultValue = "ryo@gmail.com") String email,
            @RequestParam(name = "start", defaultValue = "2023-10-23 23:59:59") String start,
            @RequestParam(name = "end", defaultValue = "2023-10-24 23:59:59") String end) {
        return logService.customsize(new RangeCustomDTO(email, start, end));

    }

}
