package com.kadaijin.kadaijin.repository.log;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kadaijin.kadaijin.model.KadaijinModel;
import com.kadaijin.kadaijin.model.log.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    // String findUsername(String userName);

    // Long findIDbyUsername(String userName);

}
