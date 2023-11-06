package com.kadaijin.kadaijin.model.DTO;

import com.kadaijin.kadaijin.model.DAO.PersonalDataModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
public class RegisterDTO {

    private String email;
    private String password;
    private String name;

    private int age;
    private int phone;
    private String country;
    private String city;


}
