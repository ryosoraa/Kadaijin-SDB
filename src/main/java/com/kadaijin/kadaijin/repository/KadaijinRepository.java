package com.kadaijin.kadaijin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kadaijin.kadaijin.model.KadaijinModel;

public interface KadaijinRepository extends JpaRepository<KadaijinModel, Integer> {

    KadaijinModel findByusername(String username);

    KadaijinModel findByPassword(String password);

    // KadaijinModel findByPage(Integer limit, Integer offset);

}
