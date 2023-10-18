package com.kadaijin.kadaijin.repository.log;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kadaijin.kadaijin.model.log.LogModel;

public interface LogRepository extends JpaRepository<LogModel, Integer> {

    @Query("SELECT l FROM LogModel l WHERE l.timestamp BETWEEN :starting AND :end AND l.userId = :id")
    List<LogModel> findByTimestampBetweenAndUserId(
            @Param("starting") String starting,
            @Param("end") String end,
            @Param("id") Integer id);

}
