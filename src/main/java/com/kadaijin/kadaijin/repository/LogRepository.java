package com.kadaijin.kadaijin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kadaijin.kadaijin.model.log.UserModel;

public interface LogRepository extends JpaRepository<UserModel, Integer> {

}
