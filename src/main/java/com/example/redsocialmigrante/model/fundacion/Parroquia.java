package com.example.redsocialmigrante.model.fundacion;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Parroquia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idParroquia;
    private String nombre;

    @OneToOne(mappedBy = "parroquia")
    @JsonBackReference
    private Ubicacion ubicacion;

//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "idCanton")
    @JsonManagedReference
    private Canton canton;
}
