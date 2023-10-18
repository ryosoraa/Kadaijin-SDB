package com.kadaijin.kadaijin.DTO.fiture;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.kadaijin.kadaijin.DTO.log.LogDTO;
import com.kadaijin.kadaijin.DTO.log.RangeDTO;
import com.kadaijin.kadaijin.DTO.log.UserDTO;
import com.kadaijin.kadaijin.model.log.LogModel;
import com.kadaijin.kadaijin.model.log.UserModel;

@Component
public class ConvertUserDTO {

    @Autowired
    ModelMapper modelMapper;

    public List<UserDTO> listModelToDTO(List<UserModel> userModels) {
        List<UserDTO> dto = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        for (UserModel model : userModels) {
            System.out.println(mapper.map(model, UserDTO.class));
            dto.add(mapper.map(model, UserDTO.class));
        }
        return dto;
    }

    public List<UserDTO> listModelToDTO(Page<UserModel> userModels) {
        ModelMapper mapper = new ModelMapper();
        List<UserDTO> dto = new ArrayList<>();
        for (UserModel model : userModels) {
            dto.add(mapper.map(model, UserDTO.class));
        }
        return dto;
    }

    public List<LogDTO> listModelToLogDTO(List<LogModel> logModels) {
        List<LogDTO> dto = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        for (LogModel model : logModels) {
            System.out.println(mapper.map(model, LogDTO.class));
            dto.add(mapper.map(model, LogDTO.class));
        }
        return dto;
    }

}
