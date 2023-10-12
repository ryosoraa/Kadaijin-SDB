package com.kadaijin.kadaijin.model.log;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Embeddable
public class LogModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer logID;

    private String timestame;

}
