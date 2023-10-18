package com.kadaijin.kadaijin.repository.log;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kadaijin.kadaijin.model.log.LogModel;

public interface LogRepository extends JpaRepository<LogModel, Integer> {

    List<LogModel> findByTimestampBetweenAndUserId(String starting, String end, Integer id);

}
