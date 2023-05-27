//package com.example.redsocialmigrante.model;
//
//import lombok.Data;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.util.Date;
//
//@Entity
//@Data
//public class Kit {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer idKit;
//
//    private String tipo;
//    private Date fecha_entrega;
//    private Boolean estado;
//    private Integer stock;
//    private String codigo;
//
//
//    @NotNull
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "idCategoria", nullable = false)
//    private Categoria idCategoria;
//
//    @NotNull
//    @OneToOne(optional = false)
//    @JoinColumn(name = "idDetalle", nullable = false)
//    private DetalleKit idDetalle;
//
//}
