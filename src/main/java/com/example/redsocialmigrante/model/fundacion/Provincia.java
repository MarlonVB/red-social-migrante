package com.example.redsocialmigrante.model.fundacion;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProvincia;
    private String nombre;

    @OneToMany(mappedBy = "provincia")
    @JsonBackReference
    private List<Canton> cantones;

    @OneToOne(mappedBy = "provincia")
    @JsonBackReference
    private Ubicacion ubicacion;

    // Getters y setters
}