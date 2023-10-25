package com.kadaijin.kadaijin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kadaijin.kadaijin.model.DAO.PersonalDataModel;

public interface PersonalDataRepository extends JpaRepository<PersonalDataModel, Integer> {

    @Query("SELECT pd FROM PersonalDataModel as pd WHERE name= :name")
    PersonalDataModel findByJeneng(@Param("name") String name);

}
