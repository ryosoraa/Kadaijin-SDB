package com.kadaijin.kadaijin.model.DTO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kadaijin.kadaijin.model.DAO.AccountsModel;
import com.kadaijin.kadaijin.model.DAO.LogModel;
import com.kadaijin.kadaijin.model.DAO.PersonalDataModel;
import com.kadaijin.kadaijin.model.converter.ConvertDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Component
public class AccountsDTO extends ConvertDTO {

    @Schema(name = "ID", example = "1", required = false)
    public Integer id;

    @Schema(name = "email", example = "ryo@gmail.com", required = true)
    public String email;

    @Schema(name = "password", example = "ryo", required = true)
    public String password;

    @Schema(name = "register", example = "2023-10-16T04:09:09", required = false)
    public Timestamp register;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Schema(name = "totalLogin", required = false)
    public Integer totalLogin;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PersonalDataModel> dataModels;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Schema(name = "Log")
    private List<LogModel> log = new ArrayList<>();

    public AccountsDTO(AccountsModel accountsModel) {
        this.id = accountsModel.getId();
        this.email = accountsModel.getEmail();
        this.password = accountsModel.getPassword();
        this.register = accountsModel.getRegister();
        this.totalLogin = accountsModel.getLogs().size();
        this.log = accountsModel.getLogs();
        this.dataModels = accountsModel.getPersonalDataModels();

    }

    public AccountsDTO(AccountsModel accountsModel, List<LogModel> logModels) {
        this.id = accountsModel.getId();
        this.email = accountsModel.getEmail();
        this.password = accountsModel.getPassword();
        this.register = accountsModel.getRegister();
        this.totalLogin = logModels.size();
        this.log = logModels;
        this.dataModels = accountsModel.getPersonalDataModels();

    }

    public AccountsDTO() {

    }

}
