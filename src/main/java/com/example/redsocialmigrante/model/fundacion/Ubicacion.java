package com.example.redsocialmigrante.model.fundacion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

//@Data
//@Entity
//public class Ubicacion {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer idUbicacion;
//    private String zona;
//    private String distrito;
//
//    @OneToOne
////    @JsonIgnore
//    @JoinColumn(name = "idProvincia")
//    private Provincia provincia;
//
////    @OneToOne
////    @JsonIgnore
////    @JoinColumn(name = "idCanton")
////    private Canton canton;
////
////    @OneToOne
////    @JsonIgnore
////    @JoinColumn(name = "idParroquia")
////    private Parroquia parroquia;
//
//
//    @OneToOne(mappedBy = "ubicacionR", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Fundacion fundacion;
//
//}

@Entity
@Data
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUbicacion;

    private String zona;
    private String distrito;

    @OneToOne
    @JoinColumn(name = "idProvincia")
    @JsonManagedReference
    private Provincia provincia;

    @OneToOne
    @JoinColumn(name = "idCanton")
    @JsonManagedReference
    private Canton canton;

    @OneToOne
    @JoinColumn(name = "idParroquia")
    @JsonManagedReference
    private Parroquia parroquia;

    @OneToOne(mappedBy = "ubicacionR", cascade = CascadeType.ALL, orphanRemoval = true)
    private Fundacion fundacion;

    // Getters y setters
}