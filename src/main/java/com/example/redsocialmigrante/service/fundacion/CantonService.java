package com.example.redsocialmigrante.service.fundacion;


import com.example.redsocialmigrante.model.fundacion.Canton;
import com.example.redsocialmigrante.service.generics.GenericService;

import java.util.Optional;

public interface CantonService extends GenericService<Canton, Integer> {

    Optional<Canton> findByNombreLike(String nombre);

    boolean existsByNombreLike(String nombre);

}
