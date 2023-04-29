package com.example.redsocialmigrante.service;

import com.example.redsocialmigrante.model.Migrante;
import com.example.redsocialmigrante.model.MigranteRedSocialRel;
import com.example.redsocialmigrante.service.generics.GenericService;

import java.util.List;
import java.util.Optional;

/**

 Interface que define los metodos para acceder y modificar las entidades MigranteRedSocialRel en la base de datos.
 */
public interface MigranteRedSocialRelService extends GenericService<MigranteRedSocialRel, Integer> {

    /**

     Busca todas las entidades MigranteRedSocialRel asociadas con un migrante en particular.
     @param migrante el migrante cuyas relaciones de red social se desean buscar.
     @return una lista de todas las entidades MigranteRedSocialRel asociadas con el migrante especificado.
     */
    List<MigranteRedSocialRel> findByMigrante(Migrante migrante);
    /**

     Elimina todas las entidades MigranteRedSocialRel asociadas con un migrante en particular.
     @param migrante el migrante cuyas relaciones de red social se desean eliminar.
     */
    void deleteByMigrante(Migrante migrante);
}





