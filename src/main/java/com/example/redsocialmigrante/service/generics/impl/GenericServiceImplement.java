package com.example.redsocialmigrante.service.generics.impl;

import com.example.redsocialmigrante.service.generics.GenericService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Optional;

/**

 Implementacion generica de un servicio CRUD que utiliza un CrudRepository.

 Esta clase proporciona una implementacion por defecto para los metodos de la interfaz GenericService.

 @param <E> La entidad que se manejara.

 @param <ID> El tipo de dato de la clave primaria de la entidad.
 */
@Service
public abstract class GenericServiceImplement<E, ID extends Serializable> implements GenericService<E, ID> {

    /**

     Metodo abstracto que debe ser implementado por la clase hija para proporcionar un CrudRepository que maneje la entidad E.
     @return Un objeto CrudRepository que maneje la entidad E.
     */
    public abstract CrudRepository<E, ID> crudRepository();
    /**

     Guarda una entidad en la base de datos.
     @param entity La entidad a guardar.
     @return La entidad guardada.
     */
    @Override
    public E save(E entity) {
        return crudRepository().save(entity);
    }
    /**

     Obtiene todas las entidades de la base de datos.
     @return Un Iterable con todas las entidades de la base de datos.
     */
    @Override
    public Iterable<E> findAll() {
        return crudRepository().findAll();
    }
    /**

     Obtiene una entidad por su clave primaria.
     @param id La clave primaria de la entidad a buscar.
     @return Un Optional que contiene la entidad si se encontro, o vacio si no.
     */
    @Override
    public Optional<E> findById(ID id) {
        return crudRepository().findById(id);
    }
    /**

     Elimina una entidad de la base de datos por su clave primaria.
     @param id La clave primaria de la entidad a eliminar.
     */
    @Override
    @Transactional
    public void deleteById(ID id) {
        crudRepository().deleteById(id);
    }
    /**

     Cuenta el numero de entidades en la base de datos.
     @return El numero de entidades en la base de datos.
     */
    @Override
    public long count() {
        return crudRepository().count();
    }
}