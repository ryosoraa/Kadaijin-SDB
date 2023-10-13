package com.kadaijin.kadaijin.model.log;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "logs")
public class LogModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer logID;

    private String timestamp;

    @ManyToOne
    @JoinColumn(name = "usersID")
    private UserModel userModel;

}
