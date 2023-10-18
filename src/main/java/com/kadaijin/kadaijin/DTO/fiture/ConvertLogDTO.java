package com.kadaijin.kadaijin.DTO.fiture;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kadaijin.kadaijin.DTO.log.LogDTO;
import com.kadaijin.kadaijin.model.log.LogModel;

@Component
public class ConvertLogDTO {

    // @Autowired
    // ModelMapper modelMapper;

    // public List<LogDTO> ListLogToDTO(Set<LogModel> set) {
    // List<LogDTO> log = new ArrayList<>();
    // for (LogModel model : set) {
    // log.add(modelMapper.map(model, LogDTO.class));
    // }
    // return log;
    // }
}
