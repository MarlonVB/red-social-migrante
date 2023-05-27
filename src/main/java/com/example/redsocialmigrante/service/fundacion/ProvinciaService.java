package com.example.redsocialmigrante.service.fundacion;

import com.example.redsocialmigrante.model.fundacion.Provincia;
import com.example.redsocialmigrante.service.generics.GenericService;

import java.util.Optional;

public interface ProvinciaService extends GenericService<Provincia, Integer> {

    Optional<Provincia> findByNombreLike(String nombre);

    boolean existsByNombreLike(String nombre);

}