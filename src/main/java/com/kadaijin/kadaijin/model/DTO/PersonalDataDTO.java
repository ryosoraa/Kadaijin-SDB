package com.kadaijin.kadaijin.model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.kadaijin.kadaijin.model.DAO.AccountsModel;
import com.kadaijin.kadaijin.model.DAO.PersonalDataModel;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class PersonalDataDTO {

    @JsonIgnore
    private Integer personalId;

    private String name;

    private Integer age;

    private Integer phone;

    private String country;

    private String city;

    @JsonIgnore
    AccountsModel accounts_id;

    public PersonalDataDTO(PersonalDataModel personalDataModel, Integer id) {
        this.personalId = personalDataModel.getPersonalId();
        this.name = personalDataModel.getName();
        this.age = personalDataModel.getAge();
        this.phone = personalDataModel.getPhone();
        this.country = personalDataModel.getCountry();
        this.city = personalDataModel.getCity();
        this.accounts_id = new AccountsModel(id);
    }

    public  PersonalDataDTO(){

    }
}
