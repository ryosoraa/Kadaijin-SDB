package com.kadaijin.kadaijin.model;

import com.kadaijin.kadaijin.DTO.KadaijinDTO;

import io.swagger.v3.oas.annotations.media.Schema;
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

    public void dtoVentity(KadaijinDTO kadaijinDTO) {
        this.Id = kadaijinDTO.getId();
        this.username = kadaijinDTO.getUsername();
        this.password = kadaijinDTO.getPassword();
    }
}
