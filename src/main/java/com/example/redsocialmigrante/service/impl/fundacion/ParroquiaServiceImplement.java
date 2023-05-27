package com.example.redsocialmigrante.service.impl.fundacion;

import com.example.redsocialmigrante.model.fundacion.Parroquia;
import com.example.redsocialmigrante.repository.fundacion.ParroquiaRepository;
import com.example.redsocialmigrante.service.fundacion.ParroquiaService;
import com.example.redsocialmigrante.service.generics.impl.GenericServiceImplement;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ParroquiaServiceImplement extends GenericServiceImplement<Parroquia, Integer> implements ParroquiaService {


    private final ParroquiaRepository parroquiaRepository;

    @Override
    public Optional<Parroquia> findByNombreLike(String nombre) {
        return parroquiaRepository.findByNombreLike(nombre);
    }

    @Override
    public boolean existsByNombreLike(String nombre) {
        return parroquiaRepository.existsByNombreLike(nombre);
    }

    @Override
    public CrudRepository<Parroquia, Integer> crudRepository() {
        return parroquiaRepository;
    }
}

