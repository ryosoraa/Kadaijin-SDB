package com.kadaijin.kadaijin.repository;

import com.kadaijin.kadaijin.model.DAO.AccountsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kadaijin.kadaijin.model.DAO.LogModel;

import java.sql.Timestamp;
import java.util.List;

public interface LogRepository extends JpaRepository<LogModel, Integer> {

}
