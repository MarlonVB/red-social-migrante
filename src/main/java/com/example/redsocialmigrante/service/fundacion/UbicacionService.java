package com.example.redsocialmigrante.service.fundacion;

import com.example.redsocialmigrante.model.fundacion.Ubicacion;
import com.example.redsocialmigrante.service.generics.GenericService;

import java.util.List;
import java.util.Optional;

public interface UbicacionService extends GenericService<Ubicacion, Integer> {

    Optional<Ubicacion> findByZonaLike(String zona);

    Optional<Ubicacion>  findByDistritoLike(String distrito);

    boolean existsByZonaLike(String zona);

    boolean existsByDistritoLike(String distrito);
    List<Ubicacion> obtenerTodasLasUbicaciones();

}
