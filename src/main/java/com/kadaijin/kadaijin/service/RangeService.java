package com.kadaijin.kadaijin.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.DTO.fiture.ConvertUserDTO;
import com.kadaijin.kadaijin.DTO.log.LogDTO;
import com.kadaijin.kadaijin.DTO.log.RangeDTO;
import com.kadaijin.kadaijin.model.log.LogModel;
import com.kadaijin.kadaijin.repository.log.LogRepository;
import com.kadaijin.kadaijin.repository.log.UserRepository;

@Service
public class RangeService {

    @Autowired
    ConvertUserDTO convertUserDTO;

    @Autowired
    LogRepository logRepository;

    @Autowired
    UserRepository userRepository;

    public RangeDTO restoreAll(String email) {
        Integer id = userRepository.findIdByUsername(email);
        RangeDTO rangeDTO = new RangeDTO();
        List<LogModel> logModel = logRepository
                .findByTimestampBetweenAndUserId(
                        "2023-10-18 10:44:01",
                        "2023-10-18 14:34:35",
                        id);

        rangeDTO.setUserName(email);
        rangeDTO.setLog(convertUserDTO.listModelToLogDTO(logModel));
        return rangeDTO;
    }

}
