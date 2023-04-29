package com.example.redsocialmigrante.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Esta clase representa un migrante con informacion relevante como su profesion, ingreso mensual, edad, genero,
 * fecha de nacimiento, correo y sus redes sociales.
 */
@Entity
@Data
public class Migrante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMigrante;

    private String profesion;
    private Double ingresoMensual;
    private String sexo;
    private Integer edad;
    private String genero;
    private String nombre;
    private Date fechaNacimiento;
    private String apellido;
    private String correo;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "migranteRedSocialRel",
//            joinColumns = @JoinColumn(name = "idMigrante"),
//            inverseJoinColumns = @JoinColumn(name = "idRedSocial"))
//    private List<RedSocial> redesSociales;

    @OneToMany(mappedBy = "migrante", cascade = CascadeType.REMOVE)
    private List<MigranteRedSocialRel> migranteRedSocialRelList;
}

