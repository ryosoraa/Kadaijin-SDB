package com.kadaijin.kadaijin.model.DAO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Table(name = "personal_data")
@Data
@Entity
public class PersonalDataModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personalId;

    private String name;

    private Integer age;

    private Integer phone;

    private String country;



    private String city;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "accounts_id")
    AccountsModel accounts_id;

    public PersonalDataModel(String name, Integer age, Integer phone, String country, String city, int accounts_id) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.accounts_id = new AccountsModel(accounts_id);
    }

    public PersonalDataModel(AccountsModel accounts_id) {
        this.accounts_id = accounts_id;
    }

    public PersonalDataModel() {

    }
}
