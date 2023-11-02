package com.kadaijin.kadaijin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kadaijin.kadaijin.model.DAO.LogModel;

public interface LogRepository extends JpaRepository<LogModel, Integer> {
    
}
