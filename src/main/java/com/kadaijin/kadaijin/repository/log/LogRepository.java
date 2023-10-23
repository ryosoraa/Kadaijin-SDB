package com.kadaijin.kadaijin.repository.log;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kadaijin.kadaijin.model.log.LogModel;
import com.kadaijin.kadaijin.model.AccountsModel;

public interface LogRepository extends JpaRepository<LogModel, Integer> {

        @Query("SELECT COUNT(l) FROM LogModel l WHERE l.accounts.id = :customValue")
        Integer countByCustomValue(@Param("customValue") Integer customValue);

        @Query("SELECT l FROM LogModel l WHERE l.login BETWEEN :startTime AND :endTime AND l.accounts IN :userIds")
        List<LogModel> findLogsBetweenLoginForUsers(
                        @Param("startTime") Timestamp startTime,
                        @Param("endTime") Timestamp endTime,
                        @Param("userIds") AccountsModel AccountsModel);

        @Query("SELECT l FROM LogModel l WHERE l.login BETWEEN :startTime AND :endTime")
        List<LogModel> findLogsBetweenLogin(
                        @Param("startTime") Timestamp startTime,
                        @Param("endTime") Timestamp endTime);

        List<LogModel> findAllByAccounts_id(AccountsModel accounts);

        List<LogModel> findAllByLogin(Timestamp timestamp);

}

/**
 * SELECT * FROM logs
 * WHERE timestamp BETWEEN "2023-10-18 10:44:01" AND "2023-10-18 14:34:35"
 * AND user_id IN (1);
 */
