package com.kadaijin.kadaijin.model.log;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @OneToMany(mappedBy = "userId") // foreign key yang ada di dalam TABLE logs
    private List<LogModel> log;

    public UserModel(Integer no) {
        this.id = no;
    }

    public UserModel() {

    }

}
