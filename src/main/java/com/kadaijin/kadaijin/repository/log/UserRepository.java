package com.kadaijin.kadaijin.repository.log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kadaijin.kadaijin.model.log.UserModel;

import jakarta.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    @Query("SELECT u.userID FROM UserModel u WHERE u.userName = :username")
    Integer findIdByUsername(@Param("username") String username);

    @Modifying
    @Query("UPDATE UserModel u SET u.totalLogin = :newTotalLogin WHERE u.userName = :username")
    int updatetotalLogin(@Param("newTotalLogin") long l, @Param("username") String username);

    // Boolean findUsername(String username);

}
