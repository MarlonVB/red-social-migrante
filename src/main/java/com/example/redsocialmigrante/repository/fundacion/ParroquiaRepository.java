package com.example.redsocialmigrante.repository.fundacion;

import com.example.redsocialmigrante.model.fundacion.Parroquia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParroquiaRepository extends JpaRepository<Parroquia, Integer> {
    Optional<Parroquia> findByNombreLike(String nombre);

    boolean existsByNombreLike(String nombre);
}