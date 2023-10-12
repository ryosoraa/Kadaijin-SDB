package com.kadaijin.kadaijin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kadaijin.kadaijin.model.log.LogMain;

public interface LogRepository extends JpaRepository<LogMain, Integer> {
    
}
