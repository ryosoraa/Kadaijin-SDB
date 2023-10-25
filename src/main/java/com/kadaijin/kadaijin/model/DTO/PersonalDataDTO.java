package com.kadaijin.kadaijin.model.DTO;

import java.util.List;

import com.kadaijin.kadaijin.model.DAO.AccountsModel;
import com.kadaijin.kadaijin.model.DAO.PersonalDataModel;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class PersonalDataDTO {
    @Id
    private Integer personalId;

    private String name;

    private Integer age;

    private Integer phone;

    private String country;

    private String city;

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
}
