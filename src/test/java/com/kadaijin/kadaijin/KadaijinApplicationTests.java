package com.kadaijin.kadaijin;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kadaijin.kadaijin.model.DAO.AccountsModel;
import com.kadaijin.kadaijin.repository.AccountsRepository;

@SpringBootTest
class KadaijinApplicationTests {

	@Autowired
	AccountsRepository accountsRepository;

	@Test
	void contextLoads() {
	}

}
