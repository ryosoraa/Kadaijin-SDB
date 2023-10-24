package com.kadaijin.kadaijin.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.kadaijin.kadaijin.model.DAO.AccountsModel;
import com.kadaijin.kadaijin.model.DTO.AccountsDTO;
import com.kadaijin.kadaijin.model.DTO.RangeCustomDTO;
import com.kadaijin.kadaijin.repository.AccountsRepository;
import com.kadaijin.kadaijin.service.RangeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/Range")
public class LogRange {

    @Autowired
    RangeService rangeService;

    @Autowired
    AccountsRepository accountsRepository;

    @Operation(summary = "Restore All Data", description = "restore all saved data")
    @PostMapping("/all")
    public AccountsDTO allData(@RequestParam String email) {
        return rangeService.restoreAll(email);
    }

    @Operation(summary = "Restore Data Customize", description = "returns data by Customize date")
    @GetMapping("/customs")
    public AccountsModel customs(
            @RequestParam(name = "email", defaultValue = "ryo@gmail.com") String email,
            @RequestParam(name = "start", defaultValue = "2023-10-23 18:50:13") String start,
            @RequestParam(name = "end", defaultValue = "2023-10-23 18:50:13") String end) {
        return rangeService.customize(new RangeCustomDTO(email, start, end));

    }

    @PostMapping("/try")
    public List<AccountsDTO> coba(@RequestParam String dates) {

        return rangeService.ranges(dates);
    }

}
