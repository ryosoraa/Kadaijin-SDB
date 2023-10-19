package com.kadaijin.kadaijin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kadaijin.kadaijin.DTO.log.RangeDTO;
import com.kadaijin.kadaijin.DTO.log.UserDTO;
import com.kadaijin.kadaijin.service.RangeService;

@RestController
@RequestMapping("/Range")
public class LogRange {

    @Autowired
    RangeService rangeModel;

    @PostMapping("/all")
    public UserDTO allData(@RequestParam String email) {
        return rangeModel.restoreAll(email);
    }

    @PostMapping("/date")
    public UserDTO oneData(
            @RequestParam String email,
            @RequestParam String date) {
        return rangeModel.range(email, date);
    }

    @PostMapping("/month")
    public UserDTO month(
            @RequestParam String email,
            @RequestParam String month,
            @RequestParam String years) {
        return rangeModel.range(email, month, years);
    }

    @PostMapping("/years")
    public UserDTO years(
            @RequestParam String email,
            @RequestParam String years) {
        return rangeModel.rangeYears(email, years);
    }

    @PostMapping("/customs")
    public UserDTO customs(
            @RequestParam String email,
            @RequestParam String start,
            @RequestParam String end) {
        return null;
    }

}
