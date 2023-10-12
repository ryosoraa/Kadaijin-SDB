package com.kadaijin.kadaijin.model.log;

import java.util.List;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Data;

@Data
@Embeddable
public class UserModel {

    private String username;

    @Embedded
    private List<Log> logs;

    private String totalLogin;

}
