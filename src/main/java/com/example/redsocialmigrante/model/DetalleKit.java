//package com.example.redsocialmigrante.model;
//
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//import lombok.Data;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.util.Date;
//import java.util.List;
//
//@Entity
//@Data
//public class DetalleKit {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer idDetalle;
//
//    private Date fecha_expiracion;
//    private String observacion;
//    private Integer cantidad_producto;
//    private String nombre_institucion;
//    private String unidad_medida;
//
//
//
//    @JsonManagedReference
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleKit")
//    private List<Producto> producto;
//
//    @NotNull
//    @OneToOne (optional = false)
//    @JoinColumn(name = "idKit", nullable = false)
//    private Kit idKit;
//}
