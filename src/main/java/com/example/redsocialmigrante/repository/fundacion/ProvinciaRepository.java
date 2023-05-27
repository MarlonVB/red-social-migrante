package com.example.redsocialmigrante.repository.fundacion;

import com.example.redsocialmigrante.model.fundacion.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Integer> {

    Optional<Provincia> findByNombreLike(String nombre);

    boolean existsByNombreLike(String nombre);



}