package com.example.redsocialmigrante.dto.fundacion;

import com.example.redsocialmigrante.model.fundacion.Canton;
import com.example.redsocialmigrante.model.fundacion.Parroquia;
import com.example.redsocialmigrante.model.fundacion.Provincia;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
public class UbicacionDTO {

    private String zona;
    private String distrito;
//    private Provincia provincia;
//    private Canton canton;
//    private Parroquia parroquia;

    private String nombreProvincia;
    private String nombreCanton;
    private String nombreParroquia;
}
