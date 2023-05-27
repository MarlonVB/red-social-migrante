package com.example.redsocialmigrante.repository.fundacion;

import com.example.redsocialmigrante.model.fundacion.Canton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CantonRepository extends JpaRepository<Canton, Integer> {

    Optional<Canton> findByNombreLike(String nombre);

    boolean existsByNombreLike(String nombre);

}