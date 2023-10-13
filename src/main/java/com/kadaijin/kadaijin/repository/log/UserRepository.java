package com.kadaijin.kadaijin.repository.log;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kadaijin.kadaijin.model.KadaijinModel;
import com.kadaijin.kadaijin.model.log.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    KadaijinModel findUsername(String username);

}
