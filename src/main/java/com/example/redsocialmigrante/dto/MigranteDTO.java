package com.example.redsocialmigrante.dto;

import com.example.redsocialmigrante.model.MigranteRedSocialRel;
import lombok.Data;

import java.util.Date;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Clase DTO para representar los datos de un migrante.
 */

@Data
public class MigranteDTO {
    private String profesion;
    private Double ingresoMensual;
    private String sexo;
    private Integer edad;
    private String genero;
    private String nombre;
    private Date fechaNacimiento;
    private String apellido;
    private String correo;
    private List<RedSocialDTO> redesSociales;
}


