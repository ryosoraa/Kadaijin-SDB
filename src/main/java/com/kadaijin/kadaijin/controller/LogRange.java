package com.kadaijin.kadaijin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kadaijin.kadaijin.DTO.log.UserDTO;
import com.kadaijin.kadaijin.service.RangeService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/Range")
public class LogRange {

    @Autowired
    RangeService rangeService;

    @Operation(summary = "Restore All Data", description = "restore all saved data")
    @PostMapping("/all")
    public UserDTO allData(@RequestParam String email) {
        return rangeService.restoreAll(email);
    }

    @Operation(summary = "Restore One Data", description = "returns data by email and Date")
    @PostMapping("/date")
    public UserDTO oneData(
            @RequestParam(required = false) String email,
            @RequestParam String date) {

        return rangeService.range(email, date);
    }

    @Operation(summary = "Restore Data via month", description = "returns data by email and month")
    @PostMapping("/month")
    public UserDTO month(
            @RequestParam String email,
            @RequestParam String month,
            @RequestParam String years) {
        return rangeService.range(email, month, years);
    }

    @Operation(summary = "Restore Data via Years", description = "returns data by email and Years")
    @PostMapping("/years")
    public UserDTO years(
            @RequestParam String email,
            @RequestParam String years) {
        return rangeService.rangeYears(email, years);
    }

    @Operation(summary = "Restore Data Customize", description = "returns data by Customize date")
    @PostMapping("/customs")
    public UserDTO customs(
            @RequestParam String email,
            @RequestParam String start,
            @RequestParam String end) {
        return rangeService.customize(email, start, end);
    }

}
