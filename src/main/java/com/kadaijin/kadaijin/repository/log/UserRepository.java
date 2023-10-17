package com.kadaijin.kadaijin.repository.log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kadaijin.kadaijin.model.log.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    @Query("SELECT u.id FROM UserModel u WHERE u.userName = :username")
    Integer findIdByUsername(@Param("username") String username);

    UserModel findByUserName(String username);

}
