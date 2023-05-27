package com.example.redsocialmigrante.dto.fundacion;

import lombok.Data;

import java.util.Date;

@Data
public class FundacionDTO {

    private String nombreUnidad;
    private String codigoUnidad;
    private Date fechaContrato;
    private UbicacionDTO ubicacionDTO;
}
