package com.kadaijin.kadaijin.model;

import com.kadaijin.kadaijin.DTO.KadaijinDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class KadaijinModel {

    /** model mewakili tabel yang ada di dalam database */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // untuk menghasilkan nilai id
    private Integer Id;

    private String username;

    private String password;

    private String created;

}
