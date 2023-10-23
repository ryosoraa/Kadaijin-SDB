package com.kadaijin.kadaijin.model.log;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Timestamp;

import com.kadaijin.kadaijin.model.AccountsModel;

@Data
@Table(name = "logs")
@Entity
public class LogModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login", nullable = true)
    private Timestamp login;

    @ManyToOne
    @JoinColumn(name = "accounts_id", nullable = false)
    private AccountsModel accounts;

    public LogModel() {

    }

    public LogModel(Integer no) {
        this.accounts = new AccountsModel(no);
    }

}
