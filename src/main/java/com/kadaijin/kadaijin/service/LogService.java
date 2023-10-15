package com.kadaijin.kadaijin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kadaijin.kadaijin.DTO.log.UserDTO;
import com.kadaijin.kadaijin.model.KadaijinModel;
import com.kadaijin.kadaijin.model.log.LogModel;
import com.kadaijin.kadaijin.model.log.UserModel;
import com.kadaijin.kadaijin.repository.log.LogRepository;
import com.kadaijin.kadaijin.repository.log.UserRepository;
import org.springframework.data.repository.CrudRepository;

@Service
public class LogService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LogRepository logRepository;

    // @Autowired
    // private UserDTO userDTO;

    @Transactional
    public void logInsert(UserModel userModel) {

        long count = logRepository.countByID(1);
        System.out.println(count);
        System.out.println(logRepository.countByID(userRepository.findIdByUsername(userModel.getUserName())));
        userRepository.updatetotalLogin(
                logRepository.countByID(userRepository.findIdByUsername(userModel.getUserName())),
                userModel.getUserName());
        if (userRepository.findIdByUsername(userModel.getUserName()) == null) {
            userRepository.save(userModel);
        }

        Integer foreignKey = userRepository.findIdByUsername(userModel.getUserName());

        // Buat instance LogModel
        LogModel logModel = new LogModel();
        logModel.setID(foreignKey);

        // Simpan LogModel
        logRepository.save(logModel);
    }

    public List<UserDTO> getLog() {
        UserDTO userDTO = new UserDTO();
        List<UserModel> userModel = userRepository.findAll();
        return userDTO.listModelToDTO(userModel);
    }

    public UserDTO getOneName(String request) {
        UserDTO userDTO = new UserDTO();
        UserModel userModel = userRepository.findByUserName(request);
        return userDTO.userModelToDTO(userModel);

    }
}
