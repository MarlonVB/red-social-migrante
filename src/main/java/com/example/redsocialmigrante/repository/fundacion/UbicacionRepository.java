package com.example.redsocialmigrante.repository.fundacion;

import com.example.redsocialmigrante.model.fundacion.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UbicacionRepository extends JpaRepository<Ubicacion, Integer> {
    Optional<Ubicacion> findByZonaLike(String zona);
    Optional<Ubicacion>  findByDistritoLike(String distrito);

    boolean existsByZonaLike(String zona);

    boolean existsByDistritoLike(String distrito);

    @Query(value = "select * from ubicacion", nativeQuery = true)
    List<Ubicacion> obtenerTodasLasUbicaciones();

}