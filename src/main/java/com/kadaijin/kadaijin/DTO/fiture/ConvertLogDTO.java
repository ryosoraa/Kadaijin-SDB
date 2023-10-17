package com.kadaijin.kadaijin.DTO.fiture;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kadaijin.kadaijin.DTO.log.LogDTO;
import com.kadaijin.kadaijin.model.log.LogModel;

@Component
public class ConvertLogDTO {

    public LogDTO logDTO(LogModel logModel) {
        LogDTO logDTO = new LogDTO();
        logDTO.setID(logModel.getId());
        logDTO.setTimestamp(logModel.getTimestamp());
        return logDTO;
    }

    public List<LogDTO> ListLogToDTO(List<LogModel> logModel) {
        List<LogDTO> log = new ArrayList<>();
        for (LogModel model : logModel) {
            LogDTO dto = new LogDTO();
            log.add(dto.logDTO(model));
        }
        return log;
    }
}
