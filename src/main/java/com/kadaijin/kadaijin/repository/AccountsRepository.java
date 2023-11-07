package com.kadaijin.kadaijin.repository;

import java.sql.Timestamp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kadaijin.kadaijin.model.DAO.AccountsModel;

public interface AccountsRepository extends JpaRepository<AccountsModel, Integer> {

        @Query("SELECT a FROM AccountsModel a RIGHT JOIN a.logs l WHERE a.email = :email")
        AccountsModel findByEmails(@Param("email") String email);

        boolean existsByEmailAndPassword(String username, String password);

        @Query("SELECT u.id FROM AccountsModel u WHERE u.email = :email")
        Integer findIdByEmail(@Param("email") String email);



  /*      @Query(value = "SELECT a.id , a.email, a.password, a.register, l.logs_id, l.login FROM accounts a LEFT JOIN logs l ON a.id = l.accounts_id AND l.login BETWEEN :start AND :end WHERE a.email = :email", nativeQuery = true)
        AccountsModel findByEmailAndLogBetweenDates(@Param("email") String email,
                        @Param("start") Timestamp start,
                        @Param("end") Timestamp end);*/

        @Query("SELECT a FROM AccountsModel a INNER JOIN FETCH a.logs l WHERE a.email = :email AND l.login BETWEEN :start AND :end")
        AccountsModel findByEmailAndLogBetweenDates(@Param("email") String email,
                                                   @Param("start") Timestamp start,
                                                   @Param("end") Timestamp end);

        @Query("SELECT a FROM AccountsModel a LEFT JOIN a.personalDataModels")
        Page<AccountsModel> findByPage(Pageable pageable);

//         AccountsModel findAccountsByEmailAndLogsLoginBetween(String email, Timestamp start, Timestamp end);



}
