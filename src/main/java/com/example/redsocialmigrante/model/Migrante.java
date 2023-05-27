//package com.example.redsocialmigrante.model;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.List;
//
///**
// * Esta clase representa un migrante con informacion relevante como su profesion, ingreso mensual, edad, genero,
// * fecha de nacimiento, correo y sus redes sociales.
// */
//@Entity
//@Data
//public class Migrante {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer idMigrante;
//
//    private String profesion;
//    private Double ingresoMensual;
//    private String sexo;
//    private Integer edad;
//    private String genero;
//    private String nombre;
//    private Date fechaNacimiento;
//    private String apellido;
//    private String correo;
//    private Boolean estadoRepresentante;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_representante")
//    private Migrante representante;
//
//    @ManyToOne()
//    @JoinColumn(name = "idGrupoFamiliar")
//    private GrupoFamiliar grupoFamiliar;
//
//    @OneToMany(mappedBy = "migrante")
//    private List<MigranteRedSocialRel> migranteRedSocialRelList;
//}
//
