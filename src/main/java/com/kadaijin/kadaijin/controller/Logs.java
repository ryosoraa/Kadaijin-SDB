package com.kadaijin.kadaijin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kadaijin.kadaijin.DTO.KadaijinDTO;
import com.kadaijin.kadaijin.DTO.log.UserDTO;
import com.kadaijin.kadaijin.model.log.UserModel;
import com.kadaijin.kadaijin.repository.KadaijinRepository;
import com.kadaijin.kadaijin.service.LogService;
import com.kadaijin.kadaijin.service.LoginService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/logs")
public class Logs {

    @Autowired
    private LogService logService;

    @Autowired
    private LoginService loginService;

    @Autowired
    KadaijinRepository kadaijinRepository;

    @Operation(summary = "Restore All Data", description = "restore all saved data")
    @GetMapping("/all")
    private List<UserDTO> getDataLog() {
        return this.logService.getLog();
    }

    @Operation(summary = "Get Data Log", description = "Get login log via email name")
    @GetMapping
    @Query("example@gmail.com")
    private UserDTO getOne(@RequestParam String email) {
        return this.logService.getOneName(email);
    }

    @Operation(summary = "Returns data by page", description = "restore email data and login logs with page")
    @GetMapping("/page")
    private List<UserDTO> getPage(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        return logService.getPage(page, size);
    }

}
