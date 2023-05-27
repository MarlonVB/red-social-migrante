package com.example.redsocialmigrante.model.fundacion;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Fundacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFundacion;
    private String nombreUnidad;
    private String codigoUnidad;
    private Date fechaContrato;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUbicacion")
    private Ubicacion ubicacionR;
}
