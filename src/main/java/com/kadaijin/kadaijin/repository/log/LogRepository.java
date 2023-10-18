package com.kadaijin.kadaijin.repository.log;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kadaijin.kadaijin.model.log.LogModel;
import com.kadaijin.kadaijin.model.log.UserModel;

public interface LogRepository extends JpaRepository<LogModel, Integer> {

    @Query("SELECT l FROM LogModel l WHERE l.timestamp BETWEEN :startTime AND :endTime AND l.userId IN :userIds")
    List<LogModel> findLogsBetweenTimestampsForUsers(@Param("startTime") Timestamp startTime,
            @Param("endTime") Timestamp endTime,
            @Param("userIds") UserModel userModel);

}
