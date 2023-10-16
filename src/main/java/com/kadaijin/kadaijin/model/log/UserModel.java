package com.kadaijin.kadaijin.model.log;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;

    @Column(name = "userName")
    private String userName;

    @OneToMany(mappedBy = "ID") // foreign key yang ada di dalam TABLE logs
    private List<LogModel> log = new ArrayList<>();

    @Column(name = "totalLogin")
    private int totalLogin;
}
