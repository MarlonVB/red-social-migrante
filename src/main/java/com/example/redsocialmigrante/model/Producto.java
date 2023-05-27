//package com.example.redsocialmigrante.model;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//@Entity
//@Data
//public class Producto {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer idProducto;
//
//    private String nombre;
//    private Boolean estado;
//
//    @NotNull
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "idCategoria", nullable = false)
//    private Categoria idCategoria;
//
//    @ManyToOne(optional = false,cascade= CascadeType.ALL)
//    private DetalleKit detalleKit;
//}
