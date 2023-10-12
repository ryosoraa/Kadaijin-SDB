package com.kadaijin.kadaijin.model;

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
    @Schema(name = "ID", example = "1", required = true)
    private Integer Id;

    @Schema(name = "username", example = "elda@gmail.com", required = true)
    private String username;

    @Schema(name = "password", example = "elda", required = true)
    private String password;
}
