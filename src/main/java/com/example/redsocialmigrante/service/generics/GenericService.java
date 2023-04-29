package com.example.redsocialmigrante.service.generics;

import java.io.Serializable;
import java.util.Optional;

/**
 * Interfaz generica para servicios.
 * @param <E> Tipo de entidad.
 * @param <ID> Tipo de identificador de entidad.
 */
public interface GenericService<E, ID extends Serializable> {

    /**
     * Guarda una entidad en la base de datos.
     * @param entity Entidad que se desea guardar.
     * @return Entidad guardada.
     */
    E save(E entity);

    /**
     * Obtiene todas las entidades.
     * @return Iterable con todas las entidades.
     */
    Iterable<E> findAll();

    /**
     * Busca una entidad por su ID.
     * @param id Identificador de la entidad que se desea buscar.
     * @return Optional que contiene la entidad si se encuentra o vacio si no se encuentra.
     */
    Optional<E> findById(ID id);

    /**
     * Elimina una entidad por su ID.
     * @param id Identificador de la entidad que se desea eliminar.
     */
    void deleteById(ID id);

    /**
     * Obtiene el numero de entidades.
     * @return Numero de entidades.
     */
    long count();
}
