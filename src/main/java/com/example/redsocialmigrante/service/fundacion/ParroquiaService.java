package com.example.redsocialmigrante.service.fundacion;

import com.example.redsocialmigrante.model.fundacion.Parroquia;
import com.example.redsocialmigrante.service.generics.GenericService;

import java.util.Optional;

public interface ParroquiaService extends GenericService<Parroquia, Integer> {

    Optional<Parroquia> findByNombreLike(String nombre);

    boolean existsByNombreLike(String nombre);

}