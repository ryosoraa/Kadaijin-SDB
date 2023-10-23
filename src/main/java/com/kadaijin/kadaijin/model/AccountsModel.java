package com.kadaijin.kadaijin.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import com.kadaijin.kadaijin.model.log.LogModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "accounts")
public class AccountsModel {

    /** model mewakili tabel yang ada di dalam database */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // untuk menghasilkan nilai id
    private Integer Id;

    private String username;

    private String password;

    @Column(name = "register", columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    private Timestamp register;

    @OneToMany(mappedBy = "userId")
    private LogModel log;

}
