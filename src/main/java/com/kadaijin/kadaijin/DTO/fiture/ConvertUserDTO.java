package com.kadaijin.kadaijin.DTO.fiture;

import com.kadaijin.kadaijin.DTO.log.UserDTO;
import com.kadaijin.kadaijin.model.log.UserModel;

public class ConvertUserDTO {
    
    public UserDTO userDTO(UserModel userModel) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(userModel.getUserName());
        userDTO.setTotalLogin(userModel.getTotalLogin());
        userDTO.setLog(userModel.getLog());

        return userDTO;
    }
}
