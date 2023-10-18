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

}
