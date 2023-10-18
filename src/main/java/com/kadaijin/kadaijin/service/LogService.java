package com.kadaijin.kadaijin.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kadaijin.kadaijin.DTO.log.UserDTO;
import com.kadaijin.kadaijin.model.log.LogModel;
import com.kadaijin.kadaijin.model.log.UserModel;
import com.kadaijin.kadaijin.repository.log.LogRepository;
import com.kadaijin.kadaijin.repository.log.UserRepository;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class LogService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LogRepository logRepository;

    @Autowired
    EntityManager entityManager;

    @Autowired
    ModelMapper modelMapper;
    // private UserDTO userDTO;

    // @Transactional // merubah kolom dalam database dan karena melakukan banyak
    // operasi secara
    // bersamaan
    public void logInsert(String username) {

        if (userRepository.findByUserName(username) == null) {
            UserModel userModel = new UserModel();
            userModel.setUserName(username);
            userRepository.save(userModel);
        }
        // System.out.println(name.toString());

        Integer id = userRepository.findIdByUsername(username);
        LogModel logModel = new LogModel(id);
        logRepository.save(logModel);

        // System.out.println(name.toString());

        // Integer foreignKey =
        // userRepository.findIdByUsername(userModel.getUserName());
        // System.out.println(foreignKey);

        // { // SET ID
        // UserModel model = new UserModel();
        // model.setId(foreignKey);
        // LogModel logModel = new LogModel();
        // logModel.setUserId(userModel);
        // logRepository.save(logModel);
        // }

    }

    public List<UserDTO> getLog() {
        UserDTO userDTO = new UserDTO();
        List<UserModel> userModel = userRepository.findAll();
        return userDTO.listModelToDTO(userModel);
    }

    public UserDTO getOneName(String request) {
        UserModel userModel = userRepository.findByUserName(request);
        return modelMapper.map(userModel, UserDTO.class);

    }

    public List<UserDTO> getPage(Integer page, Integer size) {
        UserDTO userDTO = new UserDTO();
        Pageable pageable = PageRequest.of(page, size);
        Page<UserModel> pageResult = userRepository.findAll(pageable);

        return userDTO.listModelToDTO(pageResult);
    }
}
