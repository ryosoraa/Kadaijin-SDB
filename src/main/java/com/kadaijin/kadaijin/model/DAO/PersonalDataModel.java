package com.kadaijin.kadaijin.model.DAO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

}
