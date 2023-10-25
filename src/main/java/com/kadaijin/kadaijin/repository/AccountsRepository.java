package com.kadaijin.kadaijin.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kadaijin.kadaijin.model.DAO.AccountsModel;

public interface AccountsRepository extends JpaRepository<AccountsModel, Integer> {

        AccountsModel findByEmail(String email);

        @Query("SELECT a FROM AccountsModel a JOIN a.logs l WHERE a.email = :email")
        AccountsModel findByEmails(@Param("email") String email);

        AccountsModel findByPassword(String password);

        boolean existsByEmailAndPassword(String username, String password);

        // accountsModel findByPage(Integer limit, Integer offset);

        @Query("SELECT u.id FROM AccountsModel u WHERE u.email = :email")
        Integer findIdByEmail(@Param("email") String email);

        @Query("SELECT a FROM AccountsModel a LEFT JOIN a.logs l WHERE a.id = :id AND l.login BETWEEN :start AND :end")
        AccountsModel findByIdAndLog(
                        @Param("id") Integer id,
                        @Param("start") Timestamp start,
                        @Param("end") Timestamp end);

        @Query("SELECT DISTINCT a FROM AccountsModel a INNER JOIN FETCH a.logs l WHERE l.login BETWEEN :start AND :end")
        List<AccountsModel> findAccountsModelAndLogs(
                        @Param("start") Timestamp start,
                        @Param("end") Timestamp end);

        // AccountsModel findByUserName(String username);

}
