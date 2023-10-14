package com.kadaijin.kadaijin.repository.log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kadaijin.kadaijin.model.KadaijinModel;
import com.kadaijin.kadaijin.model.log.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    // String findUsername(String userName);
    @Query("SELECT u.userID FROM User u WHERE u.userName = :username")
    Long findIdByUsername(@Param("username") String username);

}
