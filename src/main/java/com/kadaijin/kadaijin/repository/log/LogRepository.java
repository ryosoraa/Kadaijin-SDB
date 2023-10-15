package com.kadaijin.kadaijin.repository.log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kadaijin.kadaijin.model.log.LogModel;

public interface LogRepository extends JpaRepository<LogModel, Long> {

    @Query("SELECT COUNT(e.id) FROM logs e WHERE e.id = :id")
    Integer countOnesInMyColumn(@Param("id") Integer long1);

}
