package com.kadaijin.kadaijin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kadaijin.kadaijin.model.AccountsModel;

public interface AccountsRepository extends JpaRepository<AccountsModel, Integer> {

    AccountsModel findByEmail(String username);

    AccountsModel findByPassword(String password);

    boolean existsByEmailAndPassword(String username, String password);

    // accountsModel findByPage(Integer limit, Integer offset);

    @Query("SELECT u.id FROM AccountsModel u WHERE u.email = :email")
    Integer findIdByEmail(@Param("email") String email);

    // AccountsModel findByUserName(String username);

}
