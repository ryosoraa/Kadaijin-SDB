package com.kadaijin.kadaijin.service;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.mapping.Value;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadaijin.kadaijin.DTO.fiture.ConvertUserDTO;
import com.kadaijin.kadaijin.DTO.log.LogDTO;
import com.kadaijin.kadaijin.DTO.log.RangeDTO;
import com.kadaijin.kadaijin.DTO.log.UserDTO;
import com.kadaijin.kadaijin.model.log.LogModel;
import com.kadaijin.kadaijin.model.log.UserModel;
import com.kadaijin.kadaijin.repository.log.LogRepository;
import com.kadaijin.kadaijin.repository.log.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class RangeService {

    @Autowired
    ConvertUserDTO convertUserDTO;

    @Autowired
    LogRepository logRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional
    public UserDTO customize(String email) {

        Integer id = userRepository.findIdByUsername(email);
        Timestamp starTimestamp = Timestamp.valueOf("2023-10-18 10:44:01");
        Timestamp endTimestamp = Timestamp.valueOf("2023-10-18 14:34:35");
        UserModel userModel = new UserModel(id);
        UserDTO userDTO = new UserDTO();
        // RangeDTO rangeDTO = new RangeDTO();
        System.out.println("jalan 1");
        List<LogModel> logModel = logRepository
                .findLogsBetweenTimestampsForUsers(
                        starTimestamp,
                        endTimestamp,
                        userModel);
        System.out.println("jalan 2");

        userDTO.setUserName(email);
        userDTO.setLog(convertUserDTO.listModelToLogDTO(logModel));
        return userDTO;
    }

    public UserDTO restoreAll(String email) {
        UserDTO userDTO = new UserDTO();
        UserModel userModel = new UserModel(userRepository.findIdByUsername(email));
        List<LogModel> logModel = logRepository.findAllByuserId(userModel);

        userDTO.setUserName(email);
        userDTO.setLog(convertUserDTO.listModelToLogDTO(logModel));
        return userDTO;
    }

    public UserDTO dates(String email, String dates) {
        UserDTO userDTO = new UserDTO();

        UserModel userModel = new UserModel(userRepository.findIdByUsername(email));
        Timestamp start = Timestamp.valueOf(dates.concat(" 00:00:00"));
        Timestamp end = Timestamp.valueOf(dates.concat(" 23:59:59"));
        List<LogModel> logModels = logRepository
                .findLogsBetweenTimestampsForUsers(start, end, userModel);

        userDTO.setUserName(email);
        userDTO.setLog(convertUserDTO.listModelToLogDTO(logModels));

        return userDTO;
    }

}
