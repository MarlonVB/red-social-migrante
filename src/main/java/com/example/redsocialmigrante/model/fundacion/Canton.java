package com.example.redsocialmigrante.model.fundacion;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Canton {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCanton;
    private String nombre;

    @OneToOne(mappedBy = "canton")
    @JsonBackReference
    private Ubicacion ubicacion;

    @ManyToOne
    @JoinColumn(name = "idProvincia")
    @JsonManagedReference
    private Provincia provincia;

//    @JsonManagedReference
    @OneToMany(mappedBy = "canton")
    @JsonBackReference
    private List<Parroquia> parroquias;

}
