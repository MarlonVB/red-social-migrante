package com.example.redsocialmigrante.service.impl;

import com.example.redsocialmigrante.model.RedSocial;
import com.example.redsocialmigrante.repository.RedSocialRespository;
import com.example.redsocialmigrante.service.RedSocialService;
import com.example.redsocialmigrante.service.generics.impl.GenericServiceImplement;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementacion de la interfaz RedSocialService que extiende de GenericServiceImplement.
 * Proporciona metodos para realizar operaciones CRUD en la entidad RedSocial.
 */
@Service
@AllArgsConstructor
public class RedSocialServiceImplement extends GenericServiceImplement<RedSocial, Integer> implements RedSocialService {

    private final RedSocialRespository redSocialRespository;

    /**
     * Retorna el repositorio correspondiente a la entidad RedSocial.
     *
     * @return el repositorio de la entidad RedSocial.
     */
    @Override
    public CrudRepository<RedSocial, Integer> crudRepository(){
        return redSocialRespository;
    }
}
