package com.kadaijin.kadaijin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kadaijin.kadaijin.model.DAO.PersonalDataModel;

public interface PersonalDataRepository extends JpaRepository<PersonalDataModel, Integer> {

}
