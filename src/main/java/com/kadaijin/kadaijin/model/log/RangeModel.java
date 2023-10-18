package com.kadaijin.kadaijin.model.log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.DTO.log.LogDTO;
import com.kadaijin.kadaijin.DTO.log.RangeDTO;
import com.kadaijin.kadaijin.repository.log.LogRepository;
import com.kadaijin.kadaijin.repository.log.UserRepository;

@Service
public class RangeModel {

    @Autowired
    RangeDTO rangeDTO;

    @Autowired
    LogDTO logDTO;

    @Autowired
    LogRepository logRepository;

    @Autowired
    UserRepository userRepository;

    public RangeDTO restoreAll(String email) {
        Integer id = userRepository.findIdByUsername(email);
        rangeDTO.setUserName(email);
        rangeDTO.setLog(logRepository.findByTimestampBetweenAndUserId(
                "2023-10-18 10:44:01",
                "2023-10-18 14:34:35",
                id));
        return null;
    }

}
