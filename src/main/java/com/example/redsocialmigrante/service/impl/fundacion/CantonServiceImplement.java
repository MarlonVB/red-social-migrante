package com.example.redsocialmigrante.service.impl.fundacion;

import com.example.redsocialmigrante.model.fundacion.Canton;
import com.example.redsocialmigrante.repository.fundacion.CantonRepository;
import com.example.redsocialmigrante.service.fundacion.CantonService;
import com.example.redsocialmigrante.service.generics.impl.GenericServiceImplement;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CantonServiceImplement extends GenericServiceImplement<Canton, Integer> implements CantonService {

    private final CantonRepository cantonRepository;

    @Override
    public Optional<Canton> findByNombreLike(String nombre) {
        return cantonRepository.findByNombreLike(nombre);
    }

    @Override
    public boolean existsByNombreLike(String nombre) {
        return cantonRepository.existsByNombreLike(nombre);
    }

    @Override
    public CrudRepository<Canton, Integer> crudRepository() {
        return cantonRepository;
    }
}
/*
@Service
@AllArgsConstructor
public class ProvinciaServiceImplement extends GenericServiceImplement<Provincia, Integer> implements ProvinciaService {

    private final ProvinciaRepository provinciaRepository;

    @Override
    public CrudRepository<Provincia, Integer> crudRepository() {
        return provinciaRepository;
    }

    @Override
    public Optional<Provincia> findByNombreLike(String nombre) {
        return provinciaRepository.findByNombreLike(nombre);
    }

    @Override
    public boolean existsByNombreLike(String nombre) {
        return provinciaRepository.existsByNombreLike(nombre);
    }
}
 */