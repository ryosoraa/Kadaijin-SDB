package com.kadaijin.kadaijin.repository.log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kadaijin.kadaijin.model.log.LogModel;

public interface LogRepository extends JpaRepository<LogModel, Integer> {

    long countByID(Integer ID);

}
