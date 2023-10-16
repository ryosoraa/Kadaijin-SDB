package com.kadaijin.kadaijin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kadaijin.kadaijin.DTO.log.UserDTO;
import com.kadaijin.kadaijin.model.log.LogModel;
import com.kadaijin.kadaijin.model.log.UserModel;
import com.kadaijin.kadaijin.repository.log.LogRepository;
import com.kadaijin.kadaijin.repository.log.UserRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class LogService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LogRepository logRepository;

    // @Autowired
    // private UserDTO userDTO;

    @Transactional // merubah kolom dalam database dan karena melakukan banyak operasi secara
                   // bersamaan
    public void logInsert(UserModel userModel) {
        userRepository.updatetotalLogin(
                logRepository.countByID(userRepository.findIdByUsername(userModel.getUserName())),
                userModel.getUserName());
        if (userRepository.findIdByUsername(userModel.getUserName()) == null) {
            userRepository.save(userModel);
            userRepository.updatetotalLogin(1, userModel.getUserName());
        }

        Integer foreignKey = userRepository.findIdByUsername(userModel.getUserName());

        // Buat instance LogModel
        LogModel logModel = new LogModel();
        logModel.setID(foreignKey);
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

    public List<UserDTO> getPage(Integer page, Integer size) {
        UserDTO userDTO = new UserDTO();
        Pageable pageable = PageRequest.of(page, size);
        Page<UserModel> pageResult = userRepository.findAll(pageable);

        return userDTO.listModelToDTO(pageResult);
    }
}
