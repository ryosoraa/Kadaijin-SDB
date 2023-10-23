package com.kadaijin.kadaijin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kadaijin.kadaijin.model.AccountsModel;

public interface KadaijinRepository extends JpaRepository<AccountsModel, Integer> {

    AccountsModel findByUsername(String username);

    AccountsModel findByPassword(String password);

    boolean existsByUsernameAndPassword(String username, String password);

    // accountsModel findByPage(Integer limit, Integer offset);

}
