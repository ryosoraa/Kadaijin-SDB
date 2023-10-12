package com.kadaijin.kadaijin.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kadaijin.kadaijin.model.KadaijinModel;
import com.kadaijin.kadaijin.repository.KadaijinRepository;
import com.kadaijin.kadaijin.service.GetService;
import com.kadaijin.kadaijin.service.LoginService;
import com.kadaijin.kadaijin.service.RegisterService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/API/V1")
public class Control {

    @Autowired // seperti saling terkoneksi dengan yang di path service
    private RegisterService registerService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private GetService getService;

    @Autowired
    private KadaijinRepository kadaijinRepository;

    @PostMapping
    private void apiTest(@RequestBody KadaijinModel loginModel) {
        System.out.println("register : " + loginModel.toString());
        this.registerService.insert(loginModel);

    }

    @PostMapping("/login")
    private void login(@RequestBody KadaijinModel kadaijinModel) {
        this.loginService.cekLogin(kadaijinModel);

    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - id exceeds limit")
    })
    @Operation(summary = "Restore data", description = "returns data by id")
    @GetMapping("/get")
    private Optional<KadaijinModel> getDataOne(@RequestParam(defaultValue = "1") Integer id) {
        return this.getService.getOne(id);

    }

    @Operation(summary = "Restore All Data", description = "restore all saved data")
    @GetMapping("/get/all")
    private List<KadaijinModel> getAllData() {
        return this.getService.getData();
    }

    @Operation(summary = "Returns data by page", description = "returns the desired amount of data")
    @GetMapping("/get/page")
    private ResponseEntity<List<KadaijinModel>> paging(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        List<KadaijinModel> kadaijinList = getService.getPages(page, size);

        return new ResponseEntity<>(kadaijinList, HttpStatus.OK);
    }

}
