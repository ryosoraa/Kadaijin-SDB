package com.kadaijin.kadaijin.utils;

import com.kadaijin.kadaijin.model.DAO.LogModel;
import com.kadaijin.kadaijin.model.DTO.RangeCustomDTO;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

public class Paging {

    public List<LogModel> page (RangeCustomDTO rangeCustomDTO , List<LogModel> logModels){

        return logModels.stream()
                .skip((rangeCustomDTO.getPage() -1) * rangeCustomDTO.getSize())
                .limit(rangeCustomDTO.getSize())
                .collect(Collectors.toList());
    }
}
