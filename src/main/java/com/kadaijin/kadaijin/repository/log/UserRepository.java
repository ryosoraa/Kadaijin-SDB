package com.kadaijin.kadaijin.repository.log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kadaijin.kadaijin.model.log.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    @Query("SELECT u.id FROM UserModel u WHERE u.username = :username")
    Integer findIdByUsername(@Param("username") String username);

    @Modifying
    @Query("UPDATE UserModel u SET u.total_login = :newTotalLogin WHERE u.username = :username")
    int updatetotalLogin(@Param("newTotalLogin") long l, @Param("username") String username);

    UserModel findByUsername(String username);

}
