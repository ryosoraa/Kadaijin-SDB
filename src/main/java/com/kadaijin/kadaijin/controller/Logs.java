package com.kadaijin.kadaijin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.kadaijin.kadaijin.model.DTO.AccountsDTO;
import com.kadaijin.kadaijin.repository.AccountsRepository;
import com.kadaijin.kadaijin.service.AccountsService;
import com.kadaijin.kadaijin.service.LogService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/logs")
public class Logs {

    @Autowired
    private LogService logService;

    @Autowired
    AccountsService accountsService;

    @Autowired
    AccountsRepository AccountsRepository;

    @Operation(summary = "Get Data Log", description = "Get login log via email name")
    @GetMapping
    private ResponseEntity<AccountsDTO> getOne(@RequestParam String email) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(email, email);
        // return this.accountsService.getOne(email);
        return ResponseEntity.ok()
                .headers(headers)
                .body(accountsService.getOne(email));

    }

    @Operation(summary = "Restore All Data", description = "restore all saved data")
    @GetMapping("/all")
    private List<AccountsDTO> getDataLog() {
        return this.logService.getLog();
    }

    @Operation(summary = "Returns data by page", description = "restore email data and login logs with page")
    @GetMapping("/page")
    private List<AccountsDTO> getPage(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        return logService.getPage(page, size);
    }

    @Operation(summary = "Restore Data Customize", description = "returns data by Customize date")
    @GetMapping("/customs")
    public AccountsDTO customs(
            @RequestParam(name = "email", defaultValue = "ryo@gmail.com") String email,
            @RequestParam(name = "start", required = false) String start,
            @RequestParam(name = "end", defaultValue = "2023-10-24 23:59:59") String end) {
        return logService.customsize(email, start, end);

    }

}
