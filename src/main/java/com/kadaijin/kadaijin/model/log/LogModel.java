package com.kadaijin.kadaijin.model.log;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Table(name = "logs")
@Entity
public class LogModel {

    @Id
    private Integer id;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "user_id")
    private Integer userId;

}
