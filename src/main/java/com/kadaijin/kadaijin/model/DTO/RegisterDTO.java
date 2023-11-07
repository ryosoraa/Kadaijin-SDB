package com.kadaijin.kadaijin.model.DTO;

import com.kadaijin.kadaijin.model.DAO.PersonalDataModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
public class RegisterDTO {

    @Schema(name = "email", defaultValue = "ryo@gmail.com")
    private String email;

    @Schema(name = "password", defaultValue = "ryo@gmail.com")
    private String password;

    @Schema(name = "name", defaultValue = "ryo")
    private String name;

    @Schema(name = "age", defaultValue = "17")
    private int age;

    @Schema(name = "phone", defaultValue = "345323")
    private int phone;

    @Schema(name = "country", defaultValue = "japan")
    private String country;

    @Schema(name = "city", defaultValue = "tokyo")
    private String city;


}
