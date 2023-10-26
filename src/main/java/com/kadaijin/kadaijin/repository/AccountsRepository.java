package com.kadaijin.kadaijin.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kadaijin.kadaijin.model.DAO.AccountsModel;

public interface AccountsRepository extends JpaRepository<AccountsModel, Integer> {

        AccountsModel findByEmail(String email);

        @Query("SELECT a FROM AccountsModel a JOIN a.logs l WHERE a.email = :email")
        AccountsModel findByEmails(@Param("email") String email);

        boolean existsByEmailAndPassword(String username, String password);

        // accountsModel findByPage(Integer limit, Integer offset);

        @Query("SELECT u.id FROM AccountsModel u WHERE u.email = :email")
        Integer findIdByEmail(@Param("email") String email);

        @Query("SELECT a FROM AccountsModel a JOIN a.logs l JOIN a.personalDataModels pd WHERE a.email = :email AND l.login BETWEEN :start AND :end")
        AccountsModel findByEmailAndLog(
                        @Param("email") String email,
                        @Param("start") Timestamp start,
                        @Param("end") Timestamp end);

        @Query("SELECT a FROM AccountsModel a LEFT JOIN a.personalDataModels pd")
        Page<AccountsModel> findEmailAndPersonalDataBypage(Pageable pageable);

        // AccountsModel findByUserName(String username);

}
