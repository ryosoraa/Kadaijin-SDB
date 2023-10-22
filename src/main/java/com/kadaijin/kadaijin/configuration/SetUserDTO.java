package com.kadaijin.kadaijin.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kadaijin.kadaijin.DTO.fiture.ConvertUserDTO;
import com.kadaijin.kadaijin.DTO.log.UserDTO;
import com.kadaijin.kadaijin.model.log.LogModel;
import com.kadaijin.kadaijin.repository.log.LogRepository;
import com.kadaijin.kadaijin.repository.log.UserRepository;

@Component
public class SetUserDTO {

    @Autowired
    ConvertUserDTO convertUserDTO;

    @Autowired
    LogRepository logRepository;

    @Autowired
    UserRepository userRepository;

    public UserDTO setUserDTO(String email, List<LogModel> logModel) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userRepository.findIdByUsername(email));
        userDTO.setUserName(email);
        userDTO.setTotalLogin(logModel.size());
        userDTO.setLog(convertUserDTO.listModelToLogDTO(logModel));
        return userDTO;
    }

    public UserDTO setUserDTO(List<LogModel> logModel) {
        UserDTO userDTO = new UserDTO();
        userDTO.setTotalLogin(logModel.size());
        userDTO.setLog(convertUserDTO.listModelToLogDTO(logModel));
        return userDTO;
    }

}
