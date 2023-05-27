package com.example.redsocialmigrante.service.impl.fundacion;

import com.example.redsocialmigrante.model.fundacion.Ubicacion;
import com.example.redsocialmigrante.repository.fundacion.UbicacionRepository;
import com.example.redsocialmigrante.service.fundacion.UbicacionService;
import com.example.redsocialmigrante.service.generics.impl.GenericServiceImplement;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UbicacionServiceImplement extends GenericServiceImplement<Ubicacion, Integer> implements UbicacionService {

    private final UbicacionRepository ubicacionRepository;

    @Override
    public CrudRepository<Ubicacion, Integer> crudRepository() {
        return ubicacionRepository;
    }

    @Override
    public Optional<Ubicacion> findByZonaLike(String zona) {
        return ubicacionRepository.findByZonaLike(zona);
    }

    @Override
    public Optional<Ubicacion> findByDistritoLike(String distrito) {
        return ubicacionRepository.findByDistritoLike(distrito);
    }

    @Override
    public boolean existsByZonaLike(String zona) {
        return ubicacionRepository.existsByZonaLike(zona);
    }

    @Override
    public boolean existsByDistritoLike(String distrito) {
        return ubicacionRepository.existsByDistritoLike(distrito);
    }

    @Override
    public List<Ubicacion> obtenerTodasLasUbicaciones() {
        return ubicacionRepository.obtenerTodasLasUbicaciones();
    }
}