package com.kadaijin.kadaijin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kadaijin.kadaijin.DTO.AccountsDTO;
import com.kadaijin.kadaijin.repository.AccountsRepository;
import com.kadaijin.kadaijin.service.LogService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/logs")
public class Logs {

    @Autowired
    private LogService logService;

    @Autowired
    AccountsRepository AccountsRepository;

    @Operation(summary = "Get Data Log", description = "Get login log via email name")
    @GetMapping
    @Query("example@gmail.com")
    private AccountsDTO getOne(@RequestParam String email) {
        return this.logService.getOneName(email);
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

}
