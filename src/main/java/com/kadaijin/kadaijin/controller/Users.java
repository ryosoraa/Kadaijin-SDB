package com.kadaijin.kadaijin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kadaijin.kadaijin.DTO.KadaijinDTO;
import com.kadaijin.kadaijin.service.GetService;
import com.kadaijin.kadaijin.service.LoginService;
import com.kadaijin.kadaijin.service.RegisterService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/users")
public class Users {

    @Autowired // seperti saling terkoneksi dengan yang di path service
    private RegisterService registerService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private GetService getService;

    @Operation(summary = "Register", description = "Register new user")
    @PostMapping("/Register")
    private void apiTest(@RequestBody KadaijinDTO kadaijinDTO) {
        System.out.println("register : " + kadaijinDTO.toString());
        this.registerService.insert(kadaijinDTO);

    }

    @Operation(summary = "Login", description = "Login user")
    @PostMapping("/Login")
    public void login(@RequestBody KadaijinDTO KadaijinDTO) {
        this.loginService.newLogin(KadaijinDTO);

    }

    @Operation(summary = "Restore One Data", description = "returns data by id")
    @GetMapping("/get")
    private KadaijinDTO getDataOne(@RequestParam(defaultValue = "1") Integer id) {
        return this.getService.getOne(id);

    }

    @Operation(summary = "Restore All Data", description = "restore all saved data")
    @GetMapping("/get/all")
    private List<KadaijinDTO> getAllData() {
        return this.getService.getData();
    }

    @Operation(summary = "Returns data by page", description = "returns the desired amount of data")
    @GetMapping("/get/page")
    private List<KadaijinDTO> paging(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        List<KadaijinDTO> kadaijinList = getService.getPages(page, size);
        return kadaijinList;
    }

}
